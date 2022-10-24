import Model.Block;
import Model.WorldBoundaries;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorldBoundariesTest {

    private WorldBoundaries wb = new WorldBoundaries();


    @Test
    public void createGroundTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        List<Block> blocks = new ArrayList<>();
        int initialSizeofBlocks = blocks.size();
        blocks.add(new Block(0,0, 100, 780));
        testPrivateMethodUsingReflectionCreateGround();
        int addedBlocktoCreateGround = blocks.size();

        assertTrue(initialSizeofBlocks < addedBlocktoCreateGround);

    }


    @Test
    public void createWallsTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        List<Block> blocks = new ArrayList<>();
        int initialsizeOfBlocks = blocks.size();
        blocks.add(new Block(630, 40, 1000, 10));
        blocks.add(new Block(0,40,1000,10));

        testPrivateMethodUsingReflectionCreateWalls();
        int addedBlockstoCreateWalls = blocks.size();

        assertTrue(initialsizeOfBlocks < addedBlockstoCreateWalls);

    }

    @Test
    public void testPrivateMethodUsingReflectionCreateGround() throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = WorldBoundaries.class.getDeclaredMethod("createGround");
        method.setAccessible(true);
        method.invoke(wb);
    }
    @Test
    public void testPrivateMethodUsingReflectionCreateWalls() throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = WorldBoundaries.class.getDeclaredMethod("createWalls");
        method.setAccessible(true);
        method.invoke(wb);
    }
}
