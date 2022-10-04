import Interfaces.IEntity;
import Model.*;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollisionDetectionTest {

    @Test
    public void playerCollideswithLeftBlock(){
        Player player = new Player(9, 100);
        CollisionDetection cd =  CollisionDetection.getInstance(player);
        Block block = new Block(0,40,1000,10);

        assertTrue(cd.CheckCollisionPlayerwithLeftBlock(block));

    }


    @Test
    public void playerCollideswithRightBlock(){
        Player player = new Player(630, 100);
        CollisionDetection cd =  CollisionDetection.getInstance(player);
        Block block = new Block(630,40,1000,10);

        assertTrue(cd.CheckCollisionPlayerwithRightBlock(block));

    }

    @Test
    public void playerWillNotCollidewithLeftBlock(){
        Player player = new Player(17, 100);
        CollisionDetection cd =  CollisionDetection.getInstance(player);
        Block block = new Block(0,40,1000,10);

        assertFalse(cd.CheckCollisionPlayerwithLeftBlock(block));

    }
    @Test
    public void playerWillNotCollidewithRightBlock(){
        Player player = new Player(623, 100);
        CollisionDetection cd =  CollisionDetection.getInstance(player);
        Block block = new Block(630,40,1000,10);

        assertFalse(cd.CheckCollisionPlayerwithRightBlock(block));

    }

    @Test
    public void playerWillCollideWithEnemy(){
        Player player = new Player(200, 0);
        CollisionDetection cd = CollisionDetection.getInstance(player);
        Enemy enemy = EnemyFactory.createEnemy1();

        EntityHolder.getInstance().addEntity(enemy);
        Map<IEntity, Boolean> collision = cd.CheckCollisionPlayerAndEnemy();

        assertTrue(collision.get(enemy));
    }

    @Test
    public void playerWillNotCollideWithEnemy(){
        Player player = new Player(500,500);
        CollisionDetection cd = CollisionDetection.getInstance(player);

        Enemy enemy = EnemyFactory.createEnemy1();

        EntityHolder.getInstance().addEntity(enemy);

        Map<IEntity, Boolean> collision = cd.CheckCollisionPlayerAndEnemy();
        assertFalse(collision.get(enemy));
    }
}
