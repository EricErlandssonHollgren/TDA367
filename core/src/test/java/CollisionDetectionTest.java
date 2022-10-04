import Model.Block;
import Model.CollisionDetection;
import Model.Player;
import Model.WorldBoundaries;
import org.junit.jupiter.api.Test;

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
}
