import Interfaces.IEnemyAttack;
import Interfaces.IProjectile;
import Model.*;
import Model.Enemy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CollisionDetectionTest {
    CollisionDetection cd = CollisionDetection.getInstance();

    @Test
    public void playerCollideswithLeftBlock(){
        Player player = new Player(5, 100, 50,37,125);
        Block block = new Block(0,40,1000,10);

        assertTrue(cd.CheckCollisionPlayerWithLeftBlock(block,player));

    }

    @Test
    public void playerCollideswithRightBlock(){
        Player player = new Player(620, 100, 50 ,37,125);
        Block block = new Block(630,40,1000,10);

        assertTrue(cd.CheckCollisionPlayerWithRightBlock(block,player));

    }

    @Test
    public void playerWillNotCollidewithLeftBlock(){
        Player player = new Player(17, 100, 50 ,37,125);
        Block block = new Block(0,40,1000,10);

        assertFalse(cd.CheckCollisionPlayerWithLeftBlock(block,player));

    }
    @Test
    public void playerWillNotCollidewithRightBlock(){
        Player player = new Player(500, 100, 50 ,37,125);
        Block block = new Block(630,40,1000,10);

        assertFalse(cd.CheckCollisionPlayerWithRightBlock(block,player));

    }

    @Test
    public void playerWillCollideWithEnemyAndEnemyTakesDamage() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        Player player = new Player(200, 0, 50 ,37,125);
        Entity enemy = new Enemy(200,0,10,AttackFactory.createFireFlame(630,100),125);

        int enemyInitalHealth = enemy.getHealth();

        EntityHolder.getInstance().addEntity(enemy);
        enemyAndPlayerCollidingMethod(player, enemy);
        Thread.sleep(1000);
        player.actionHandle(ActionEnum.DAMAGE);
        player.playerAttack(enemy);
        cd.CheckCollisionPlayerAndEnemy(player);

        int enemyHealthAfterColliding = enemy.getHealth();

        assertTrue(enemyInitalHealth > enemyHealthAfterColliding);
        assertTrue(enemyAndPlayerCollidingMethod(player, enemy));
    }

    @Test
    public void playerWillNotCollideWithEnemyAndEnemyWillNotTakeDamage() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Player player = new Player(500,500, 50 ,37,125);
        Entity enemy = new Enemy(630,100,10,AttackFactory.createFireFlame(630,100),125);

        int enemyInitialHealth = enemy.getHealth();
        enemyAndPlayerCollidingMethod(player, enemy);
        cd.CheckCollisionPlayerAndEnemy(player);
        int enemyHealthAfterNotColliding = enemy.getHealth();
        assertEquals(enemyInitialHealth, enemyHealthAfterNotColliding);
        assertFalse(enemyAndPlayerCollidingMethod(player, enemy));
    }

    @Test
    public void enemyAndProjectileCollides(){

        Entity enemy = new Enemy(630,100,10,AttackFactory.createFireFlame(630,100),125);
        EntityHolder eh = EntityHolder.getInstance();
        eh.addEntity(enemy);

        IProjectile projectile = ProjectileFactory.createCannonball(630,100,0,0,16);
        Map<Entity,IProjectile> collision = cd.checkCollisionProjectileAndEnemy();
        assertTrue(collision.containsKey(enemy));
        assertTrue(collision.containsValue(projectile));
    }


    @Test
    public void enemyAndTowerCollideTowerShouldTakeDamage() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Entity enemy = new Enemy(0,100,10,AttackFactory.createFireFlame(630,100),125);
        Tower tower = new Tower(new Goldhandler());

        double towerInitialHealth = tower.getHealth();
        EntityHolder.getInstance().addEntity(enemy);

        cd.CheckCollisionTowerAndEnemy(tower);
        double towerHealthAfterColliding = tower.getHealth();

        assertFalse(EntityHolder.getInstance().getEntities().contains(enemy));
        assertTrue(towerInitialHealth > towerHealthAfterColliding);
        assertTrue(towerandEnemyisCollidingMethod(tower, enemy));



    }

    @Test
    public void enemyAndTowerDoNotCollideTowerShouldNotTakeDamage() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Entity enemy = new Enemy(200,100,10,AttackFactory.createFireFlame(630,100), 125);
        Tower tower = new Tower(new Goldhandler());

        double towerInitialHealth = tower.getHealth();
        EntityHolder.getInstance().addEntity(enemy);

        cd.CheckCollisionTowerAndEnemy(tower);
        double towerHealthAfterNotColliding = tower.getHealth();
        towerandEnemyisCollidingMethod(tower, enemy);

        assertFalse(towerandEnemyisCollidingMethod(tower, enemy));
        assertEquals(towerInitialHealth, towerHealthAfterNotColliding);
        assertTrue(EntityHolder.getInstance().getEntities().contains(enemy));
    }

    @Test
    public void enemyCollidingWithHitBoxAndTakingDamage() throws InterruptedException {
        Entity enemy = new Enemy(370,100,10,AttackFactory.createFireFlame(630,100), 125);
        Player player = new Player(320,100, 50 ,37,125);

        EntityHolder.getInstance().addEntity(enemy);

        int enemyInitialHealth  = enemy.getHealth();
        Thread.sleep(1000);
        player.actionHandle(ActionEnum.DAMAGE);
        player.playerAttack(enemy);
        cd.CheckCollisionEnemyAndHitBox(player);
        int enemyHealthAfterColliding = enemy.getHealth();

        assertTrue(EntityHolder.getInstance().getEntities().contains(enemy));
        assertTrue(enemyInitialHealth > enemyHealthAfterColliding);

    }
    @Test
    public void enemyisNotCollidingWithHitBoxAndNotTakingDamage() throws InterruptedException {
        Entity enemy = new Enemy(370,100,10,AttackFactory.createFireFlame(630,100), 125);
        Player player = new Player(100,100, 50 ,37,125);

        EntityHolder.getInstance().addEntity(enemy);

        int enemyInitialHealth  = enemy.getHealth();
        cd.CheckCollisionEnemyAndHitBox(player);
        int enemyHealthAfterNotColliding = enemy.getHealth();

        //assertFalse(EntityHolder.getInstance().getEntities().contains(enemy));
        assertEquals(enemyInitialHealth, enemyHealthAfterNotColliding);
    }
    @Test
    public void towerAndFireAttackWillCollideAttackWillBeRemoved() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        IEnemyAttack attack = AttackFactory.createFireFlame(0, 100);
        Tower tower = new Tower(new Goldhandler());

        cd.CheckCollisionTowerAndFireAttack(tower);
        towerAndFireAttackCollidingMethod(tower,attack);
        assertTrue(towerAndFireAttackCollidingMethod(tower,attack));
        assertFalse(EntityHolder.getInstance().getEnemyAttacks().contains(attack));

    }

    @Test
    public void towerAndFireAttackWillNotCollideAttackWillNotBeRemoved() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        IEnemyAttack attack = AttackFactory.createFireFlame(630,100);
        Tower tower = new Tower(new Goldhandler());

        cd.CheckCollisionTowerAndFireAttack(tower);
        towerAndFireAttackCollidingMethod(tower,attack);
        assertFalse(towerAndFireAttackCollidingMethod(tower,attack));
        assertTrue(EntityHolder.getInstance().getEnemyAttacks().contains(attack));
    }

    public boolean towerandEnemyisCollidingMethod(Tower tower, Entity enemy) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = CollisionDetection.class.getDeclaredMethod("TowerAndEnemyisColliding", Tower.class, Entity.class);
            method.setAccessible(true);
           return (boolean) method.invoke(cd, tower, enemy);

    }

    public boolean enemyAndPlayerCollidingMethod(Player player, Entity enemy) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = CollisionDetection.class.getDeclaredMethod("EnemyAndPlayerColliding", Entity.class, Player.class);
        method.setAccessible(true);
        return (boolean) method.invoke(cd, enemy, player);
    }

    public boolean towerAndFireAttackCollidingMethod(Tower tower, IEnemyAttack enemyAttack) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = CollisionDetection.class.getDeclaredMethod("TowerAndFireAttackisColliding", Tower.class, IEnemyAttack.class);
        method.setAccessible(true);
        return (boolean) method.invoke(cd, tower, enemyAttack);
    }

}

