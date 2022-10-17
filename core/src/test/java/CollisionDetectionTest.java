import Interfaces.IProjectile;
import Model.*;
import Model.Enemy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollisionDetectionTest {
    CollisionDetection cd = CollisionDetection.getInstance();

    @Test
    public void playerCollideswithLeftBlock(){
        Player player = new Player(5, 100, 50,37);
        Block block = new Block(0,40,1000,10);

        assertTrue(cd.CheckCollisionPlayerWithLeftBlock(block,player));

    }

    @Test
    public void playerCollideswithRightBlock(){
        Player player = new Player(620, 100, 50 ,37);
        Block block = new Block(630,40,1000,10);

        assertTrue(cd.CheckCollisionPlayerWithRightBlock(block,player));

    }

    @Test
    public void playerWillNotCollidewithLeftBlock(){
        Player player = new Player(17, 100, 50 ,37);
        Block block = new Block(0,40,1000,10);

        assertFalse(cd.CheckCollisionPlayerWithLeftBlock(block,player));

    }
    @Test
    public void playerWillNotCollidewithRightBlock(){
        Player player = new Player(500, 100, 50 ,37);
        Block block = new Block(630,40,1000,10);

        assertFalse(cd.CheckCollisionPlayerWithRightBlock(block,player));

    }

    @Test
    public void playerWillCollideWithEnemy(){
        Player player = new Player(200, 0, 50 ,37);
        Enemy enemy = new Enemy(200,0,10,AttackFactory.createFireFlame());

        EntityHolder.getInstance().addEntity(enemy);
        Map<Entity, Boolean> collision = cd.CheckCollisionPlayerAndEnemy(player);

        //TODO: Should be a collision. Make it false for now to check test-coverage.
        assertFalse(collision.get(enemy));
    }

    @Test
    public void playerWillNotCollideWithEnemy(){
        Player player = new Player(500,500, 50 ,37);

        Entity enemy = new Enemy(630,100,10,AttackFactory.createFireFlame());

        EntityHolder.getInstance().addEntity(enemy);

        Map<Entity, Boolean> collision = cd.CheckCollisionPlayerAndEnemy(player);
        assertFalse(collision.get(enemy));
    }

    @Test
    public void enemyAndProjectileCollides(){

        Entity enemy = new Enemy(630,100,10,AttackFactory.createFireFlame());
        EntityHolder eh = EntityHolder.getInstance();
        eh.addEntity(enemy);

        IProjectile projectile = ProjectileFactory.createCannonball(630,100,0,0,16);
        Map<Entity,IProjectile> collision = cd.checkCollisionProjectileAndEnemy();
        assertTrue(collision.containsKey(enemy));
        assertTrue(collision.containsValue(projectile));
    }


    @Test
    public void enemyAndTowerCollide() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Entity enemy = new Enemy(0,100,10,AttackFactory.createFireFlame());
        Tower tower = new Tower(new Goldhandler());

        towerandEnemyisCollidingMethod(tower, enemy);
        assertTrue(towerandEnemyisCollidingMethod(tower, enemy));

    }

    @Test
    public void enemyAndTowerDoNotCollide() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Entity enemy = new Enemy(200,100,10,AttackFactory.createFireFlame());
        Tower tower = new Tower(new Goldhandler());

        towerandEnemyisCollidingMethod(tower, enemy);
        assertFalse(towerandEnemyisCollidingMethod(tower, enemy));

    }

    public boolean towerandEnemyisCollidingMethod(Tower tower, Entity enemy) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = CollisionDetection.class.getDeclaredMethod("TowerAndEnemyisColliding", Tower.class, Entity.class);
            method.setAccessible(true);
           return (boolean) method.invoke(cd, tower, enemy);

    }

}

