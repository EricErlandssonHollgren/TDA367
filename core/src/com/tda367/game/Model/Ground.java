package Model;
import com.badlogic.gdx.utils.Array;



public class Ground {

    Array<Block> blocks = new Array<Block>();

    public Ground(){
        createGround();

    }
    public Array<Block> getBlocks(){
        return blocks;
    }

    public void createGround(){
        for (int i = 0; i < 800 ; i++) {
            blocks.add(new Block(100,100));

        }
    }
}
