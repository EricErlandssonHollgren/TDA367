package Model;
import java.util.ArrayList;
import java.util.List;

public class WorldBoundaries {

    List<Block> blocks = new ArrayList<>();

    public WorldBoundaries(){
        createGround();
        createWalls();
        createLeftWall();

    }
    public List<Block> getBlocks(){
        return blocks;
    }

    public void createGround(){
        for (int i = 0; i < 100 ; i++) {
            blocks.add(new Block(i,1, 100, 450));

        }
    }

    public void createWalls(){
        blocks.add(new Block(315, 40, 400, 10));
        blocks.add(new Block(0,40,400,10));
    }

    public void createLeftWall(){

    }
}
