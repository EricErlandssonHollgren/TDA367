import Model.Block;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlockTest {

    Block block1 = new Block(0,0, 100, 780);
    Block block2 = new Block(630, 40, 1000, 10);
    Block block3 = new Block(0,40,1000,10);

    @Test
    public void BlockTestPosX(){
        float block1PosX = block1.getX();
        float block2PosX = block2.getX();
        float block3PosX = block3.getX();

        //Check to see that they do not have the same x-value
        assertTrue(block1PosX != block2PosX);
        assertEquals(block1PosX, block3PosX);
        assertFalse(block2PosX == block3PosX);
    }

    @Test
    public void BlockTestPosY(){
        float block1PosY = block1.getY();
        float block2PosY = block2.getY();
        float block3PosY = block3.getY();

        //Check to see that they do not have the same y-val
        assertTrue(block1PosY != block2PosY);
        assertTrue(block1PosY != block3PosY);
        assertEquals(block2PosY,block3PosY);
    }

    @Test
    public void BlockTestHeight(){
        float block1height = block1.getHeight();
        float block2height = block2.getHeight();
        float block3height = block3.getHeight();

        //Check to see that each have the same height value or not
        assertTrue(block1height !=  block3height);
        assertTrue(block1height !=  block2height);
        assertEquals(block2height, block3height);
    }

    @Test
    public void BlockTestWidth(){
        float block1Width = block1.getWidth();
        float block2Width = block2.getWidth();
        float block3Width = block3.getWidth();

        //Check to see if the blocks have the same width or not

        assertEquals(block2Width, block3Width);
        assertTrue(block1Width != block2Width);
        assertTrue(block1Width != block3Width);

    }
}
