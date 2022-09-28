package Model;

import Interfaces.IEntity;
import Interfaces.IProjectile;

public class Cannonball implements IProjectile, IEntity{
    private float x,y,vx,vy,gravity;
    private String texturePath;

    public Cannonball(float x, float y, float vx, float vy, String texturePath, float gravity){
        this.gravity = gravity;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.texturePath = texturePath;
    }

    @Override
    public String getTexturePath(){
        return texturePath;
    }
    @Override
    public float getX(){
        return this.x;
    }
    @Override
    public float getY(){
        return this.y;
    }
    @Override
    public void move(){
        vy += gravity;
        x += vx;
        y += vy;
    }
}
