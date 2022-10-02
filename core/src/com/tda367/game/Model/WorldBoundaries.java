package Model;
import java.util.ArrayList;
import java.util.List;

public class WorldBoundaries {

    List<Block> blocks = new ArrayList<>();

    public WorldBoundaries(){
        createGround();
        createWalls();

    }
    public List<Block> getBlocks(){
        return blocks;
    }

    public void createGround(){
        blocks.add(new Block(0,0, 100, 780));
    }

    public void createWalls(){
        blocks.add(new Block(630, 40, 450, 10));
        blocks.add(new Block(0,40,450,10));
    }

}
