import Interfaces.IProjectile;
import Model.*;
import Model.Enemy;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollisionDetectionTest {

    @Test
    public void playerCollideswithLeftBlock(){
        Player player = new Player(5, 100, 50,37);
        CollisionDetection cd =  CollisionDetection.getInstance();
        Block block = new Block(0,40,1000,10);

        assertTrue(cd.CheckCollisionPlayerWithLeftBlock(block,player));

    }

    @Test
    public void playerCollideswithRightBlock(){
        Player player = new Player(620, 100, 50 ,37);
        CollisionDetection cd =  CollisionDetection.getInstance();
        Block block = new Block(630,40,1000,10);

        assertTrue(cd.CheckCollisionPlayerWithRightBlock(block,player));

    }

    @Test
    public void playerWillNotCollidewithLeftBlock(){
        Player player = new Player(17, 100, 50 ,37);
        CollisionDetection cd =  CollisionDetection.getInstance();
        Block block = new Block(0,40,1000,10);

        assertFalse(cd.CheckCollisionPlayerWithLeftBlock(block,player));

    }
    @Test
    public void playerWillNotCollidewithRightBlock(){
        Player player = new Player(500, 100, 50 ,37);
        CollisionDetection cd =  CollisionDetection.getInstance();
        Block block = new Block(630,40,1000,10);

        assertFalse(cd.CheckCollisionPlayerWithRightBlock(block,player));

    }

    @Test
    public void playerWillCollideWithEnemy(){
        Player player = new Player(200, 0, 50 ,37);
        CollisionDetection cd = CollisionDetection.getInstance();
        Enemy enemy = new Enemy(200,0,10,AttackFactory.createFireFlame());

        EntityHolder.getInstance().addEntity(enemy);
        Map<Entity, Boolean> collision = cd.CheckCollisionPlayerAndEnemy(player);

        assertTrue(collision.get(enemy));
    }

    @Test
    public void playerWillNotCollideWithEnemy(){
        Player player = new Player(500,500, 50 ,37);
        CollisionDetection cd = CollisionDetection.getInstance();

        Entity enemy = new Enemy(630,100,10,AttackFactory.createFireFlame());

        EntityHolder.getInstance().addEntity(enemy);

        Map<Entity, Boolean> collision = cd.CheckCollisionPlayerAndEnemy(player);
        assertFalse(collision.get(enemy));
    }

    @Test
    public void enemyAndProjectileCollides(){
        CollisionDetection cd = CollisionDetection.getInstance();

        Entity enemy = new Enemy(630,100,10,AttackFactory.createFireFlame());
        EntityHolder eh = EntityHolder.getInstance();
        eh.addEntity(enemy);

        IProjectile projectile = ProjectileFactory.createCannonball(630,100,0,0,16);
        Map<Entity,IProjectile> collision = cd.checkCollisionProjectileAndEnemy();
        assertTrue(collision.containsKey(enemy));
        assertTrue(collision.containsValue(projectile));
    }
}
