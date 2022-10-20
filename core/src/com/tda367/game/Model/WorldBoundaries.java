package Model;
import java.util.ArrayList;
import java.util.List;

public class WorldBoundaries {

    private List<Block> blocks = new ArrayList<>();

    /**
     * A constructor which adds the walls and grounds.
     */
    public WorldBoundaries(){
        createGround();
        createWalls();

    }

    /**
     * Getter for blocks
     * @return a list with blocks
     */
    public List<Block> getBlocks(){
        return blocks;
    }

    /**
     * Creating the ground by adding a block with preferred values.
     */
    private void createGround(){
        blocks.add(new Block(0,0, 100, 780));
    }


    /**
     * Creating walls by adding blocks with preferred values.
     */
    private void createWalls(){
        blocks.add(new Block(630, 40, 1000, 10));
        blocks.add(new Block(0,40,1000,10));
    }

}
