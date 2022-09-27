package Model;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Block {
    private int size = 100;
    private int x;
    private int y;

    public Vector2 getPosition() {
        return position;
    }

    Vector2 position = new Vector2();
    Rectangle bounds = new Rectangle();

    public Rectangle getBounds() {
        return bounds;
    }

    public Block(int x, int y){
        this.x = x;
        this.y = y;
        this.bounds.width = size;
        this.bounds.height = size;
    }
}
