package Model;

import com.badlogic.gdx.utils.Array;

public class Walls {
    Array<Block> blocks = new Array<Block>();

    public Walls(){
        createWalls();

    }
    public Array<Block> getBlocks(){
        return blocks;
    }

    public void createWalls(){
        blocks.add(new Block(0,102));
        blocks.add(new Block(630, 102));
    }
}