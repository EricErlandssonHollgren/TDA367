package Model;

import Model.Block;
import Model.Player;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Walls {
    Array<Block> blocks = new Array<Block>();

    Player player;

    public Player getPlayer(){
        return player;
    }

    public Walls(){
        createWalls();

    }
    public Array<Block> getBlocks(){
        return blocks;
    }

    public void createWalls(){
        blocks.add(new Block(new Vector2(0,102)));
        blocks.add(new Block(new Vector2(630,102)));
    }
}