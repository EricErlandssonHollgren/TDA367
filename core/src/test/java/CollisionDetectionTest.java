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
}
