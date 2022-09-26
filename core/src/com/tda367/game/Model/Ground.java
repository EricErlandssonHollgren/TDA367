package Model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;

import java.awt.*;
import java.util.ArrayList;


public class Ground {

    Array<Block> blocks = new Array<Block>();

    Player player;

    public Player getPlayer(){
        return player;
    }

    public Ground(){
        createGround();

    }
    public Array<Block> getBlocks(){
        return blocks;
    }

    public void createGround(){
        for (int i = 0; i < 800 ; i++) {
            blocks.add(new Block(new Vector2(i,2)));

        }
    }
}
