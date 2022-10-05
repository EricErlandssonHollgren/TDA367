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
        Player player = new Player(5, 100);
        CollisionDetection cd =  CollisionDetection.getInstance();
        Block block = new Block(0,40,1000,10);

        assertTrue(cd.CheckCollisionPlayerwithLeftBlock(block,player));

    }


    @Test
    public void playerCollideswithRightBlock(){
        Player player = new Player(620, 100);
        CollisionDetection cd =  CollisionDetection.getInstance();
        Block block = new Block(630,40,1000,10);

        assertTrue(cd.CheckCollisionPlayerwithRightBlock(block,player));

    }

    @Test
    public void playerWillNotCollidewithLeftBlock(){
        Player player = new Player(17, 100);
        CollisionDetection cd =  CollisionDetection.getInstance();
        Block block = new Block(0,40,1000,10);

        assertFalse(cd.CheckCollisionPlayerwithLeftBlock(block,player));

    }
    @Test
    public void playerWillNotCollidewithRightBlock(){
        Player player = new Player(500, 100);
        CollisionDetection cd =  CollisionDetection.getInstance();
        Block block = new Block(630,40,1000,10);

        assertFalse(cd.CheckCollisionPlayerwithRightBlock(block,player));

    }

    @Test
    public void playerWillCollideWithEnemy(){
        Player player = new Player(200, 0);
        CollisionDetection cd = CollisionDetection.getInstance();
        Enemy enemy = EnemyFactory.createEnemy1();

        EntityHolder.getInstance().addEntity(enemy);
        Map<IEntity, Boolean> collision = cd.CheckCollisionPlayerAndEnemy(player);

        assertTrue(collision.get(enemy));
    }

    @Test
    public void playerWillNotCollideWithEnemy(){
        Player player = new Player(500,500);
        CollisionDetection cd = CollisionDetection.getInstance();

        Enemy enemy = EnemyFactory.createEnemy1();

        EntityHolder.getInstance().addEntity(enemy);

        Map<IEntity, Boolean> collision = cd.CheckCollisionPlayerAndEnemy(player);
        assertFalse(collision.get(enemy));
    }
}
