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
    public void playerIsNotAbleToMoveLeft(){
        Player player = new Player(5, 100, 50,37,125);

        float initialPosX = player.getPosX();
        cd.CheckCollisionPlayerNextStep(player);
        player.moveLeft();
        float posXMoveLeft = player.getPosX();

        //Initial position of player's x should be the same if player
        //is trying to move.
        assertEquals(initialPosX, posXMoveLeft);

    }

    @Test
    public void playerIsNotAbleToMoveRight(){
        Player player = new Player(620, 100, 50 ,37,125);

        float intialPosX = player.getPosX();
        cd.CheckCollisionPlayerNextStep(player);
        player.moveRight();
        float posXMoveRight = player.getPosX();
        //Initial position of player's x should be the same if player
        //is trying to move.

        assertEquals(intialPosX, posXMoveRight);
    }

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
    public void playerWillCollideWithEnemy() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        Player player = new Player(200, 0, 50 ,37,125);
        Entity enemy = new Enemy(200,0,10,AttackFactory.createFireFlame(630,100),125);

        assertTrue(enemyAndPlayerCollidingMethod(player, enemy));
    }

    @Test
    public void enemyTakesDamage() throws InterruptedException {
        Player player = new Player(200, 0, 50 ,37,125);
        Entity enemy = new Enemy(200,0,10,AttackFactory.createFireFlame(630,100),125);

        int enemyInitalHealth = enemy.getHealth();
        EntityHolder.getInstance().addEntity(enemy);
        Thread.sleep(1000);
        player.actionHandle(ActionEnum.DAMAGE);
        player.playerAttack(enemy);
        int enemyHealthAfterColliding = enemy.getHealth();
        assertTrue(enemyInitalHealth > enemyHealthAfterColliding);
    }

    @Test
    public void playerWillNotCollideWithEnemyAndEnemyWillNotTakeDamage() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Player player = new Player(500,500, 50 ,37,125);
        Entity enemy = new Enemy(630,100,10,AttackFactory.createFireFlame(630,100),125);

        enemyAndPlayerCollidingMethod(player, enemy);
        assertFalse(enemyAndPlayerCollidingMethod(player, enemy));
    }

    @Test
    public void playerWillNotTakeDamage(){
        Player player = new Player(500,500, 50 ,37,125);
        Entity enemy = new Enemy(630,100,10,AttackFactory.createFireFlame(630,100),125);

        int enemyInitialHealth = enemy.getHealth();
        cd.CheckCollisionPlayerAndEnemy(player);
        int enemyHealthAfterNotColliding = enemy.getHealth();
        assertEquals(enemyInitialHealth, enemyHealthAfterNotColliding);

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
    public void projectileAndGroundCollides(){

        IProjectile projectile = ProjectileFactory.createCannonball(630,100,0,0,16);
        EntityHolder eh = EntityHolder.getInstance();
        eh.addProjectile(projectile);

        List<IProjectile> collision = cd.checkCollisionProjectileGround();
        assertTrue(collision.contains(projectile));

    }

    @Test
    public void enemyAndTowerCollide() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Entity enemy = new Enemy(0,100,10,AttackFactory.createFireFlame(630,100),125);
        Tower tower = new Tower(new Goldhandler());

        assertTrue(towerandEnemyisCollidingMethod(tower, enemy));
    }

    @Test
    public void towerIsTakingDamage(){
        Entity enemy = new Enemy(0,100,10,AttackFactory.createFireFlame(630,100),125);
        Tower tower = new Tower(new Goldhandler());

        double towerInitialHealth = tower.getHealth();
        EntityHolder.getInstance().addEntity(enemy);

        cd.CheckCollisionTowerAndEnemy(tower);
        double towerHealthAfterColliding = tower.getHealth();

        assertFalse(EntityHolder.getInstance().getEntities().contains(enemy));
        assertTrue(towerInitialHealth > towerHealthAfterColliding);

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
    public void towerShouldNotTakeDamage(){
        Entity enemy = new Enemy(200,100,10,AttackFactory.createFireFlame(630,100), 125);
        Tower tower = new Tower(new Goldhandler());

        double towerInitialHealth = tower.getHealth();
        EntityHolder.getInstance().addEntity(enemy);

        cd.CheckCollisionTowerAndEnemy(tower);
        double towerHealthAfterNotColliding = tower.getHealth();
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

        assertEquals(enemyInitialHealth, enemyHealthAfterNotColliding);
    }


    @Test
    public void towerAndFireAttackWillCollideAttackWillBeRemoved() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        IEnemyAttack attack = AttackFactory.createFireFlame(0, 100);
        Tower tower = new Tower(new Goldhandler());

        towerAndFireAttackCollidingMethod(tower,attack);
        assertTrue(towerAndFireAttackCollidingMethod(tower,attack));

    }

    @Test
    public void fireAttackWillbeRemovedAfterColliding(){
        IEnemyAttack attack = AttackFactory.createFireFlame(0, 100);
        Tower tower = new Tower(new Goldhandler());
        cd.CheckCollisionTowerAndFireAttack(tower);

        assertFalse(EntityHolder.getInstance().getEnemyAttacks().contains(attack));

    }

    @Test
    public void towerAndFireAttackWillNotCollideAttackWillNotBeRemoved() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        IEnemyAttack attack = AttackFactory.createFireFlame(630,100);
        Tower tower = new Tower(new Goldhandler());

        cd.CheckCollisionTowerAndFireAttack(tower);
        towerAndFireAttackCollidingMethod(tower,attack);
        assertFalse(towerAndFireAttackCollidingMethod(tower,attack));
    }

    @Test
    public void fireAttackWillNotBeRemoved(){
        IEnemyAttack attack = AttackFactory.createFireFlame(630,100);
        Tower tower = new Tower(new Goldhandler());

        cd.CheckCollisionTowerAndFireAttack(tower);
        assertTrue(EntityHolder.getInstance().getEnemyAttacks().contains(attack));

    }
    @Test
    public void playerAndFireAttackWillCollide() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        IEnemyAttack attack = AttackFactory.createFireFlame(100, 100);
        Player player = new Player(100, 100, 50,37,125);
        cd.checkCollisionPlayerAndFireAttack(player);
        playerAndFireAttackCollidingMethod(player,attack);
        assertTrue(playerAndFireAttackCollidingMethod(player,attack));
    }

    @Test
    public void playerAndFireAttackWillNotCollide() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        IEnemyAttack attack = AttackFactory.createFireFlame(400,100);
        Player player = new Player(100, 100, 50,37,125);
        cd.checkCollisionPlayerAndFireAttack(player);
        playerAndFireAttackCollidingMethod(player,attack);
        assertFalse(playerAndFireAttackCollidingMethod(player, attack));
    }




    /*
    These methods are used to be able to reach a private method.
     */
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

    public boolean playerAndFireAttackCollidingMethod(Player player, IEnemyAttack enemyAttack) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = CollisionDetection.class.getDeclaredMethod("PlayerAndFireAttackIsColliding", Player.class, IEnemyAttack.class);
        method.setAccessible(true);
        return (boolean) method.invoke(cd, player, enemyAttack);
    }

}

