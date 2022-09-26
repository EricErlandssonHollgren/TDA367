package Model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {

    private float size = 100f;

    public Vector2 getPosition() {
        return position;
    }

    Vector2 position = new Vector2();
    Rectangle bounds = new Rectangle();

    public Rectangle getBounds() {
        return bounds;
    }

    public Block(Vector2 pos){
        this.position = pos;
        this.bounds.width = size;
        this.bounds.height = size;
    }
}
