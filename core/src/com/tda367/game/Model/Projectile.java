package Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.awt.geom.Point2D;

public class Projectile {
    private Vector2 position;
    private Vector2 velocity;

    private String texturePath;

    public Projectile(Vector2 position, Vector2 velocity, String texturePath){
        this.position = position;
        this.velocity = velocity;
        this.texturePath = texturePath;
    }

    public String getTexturePath(){
        return texturePath;
    }

    public Vector2 getPosition(){
        return this.position;
    }

    public void moveProjectile(Vector2 gravity){
        position.x += velocity.x;
        velocity.y += gravity.y;
        position.y += velocity.y;
    }
}
