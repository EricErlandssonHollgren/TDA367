package Model;

import Interfaces.IProjectile;

public class Cannonball implements IProjectile {
    private float x,y,vx,vy,gravity, damage;

    public Cannonball(float x, float y, float vx, float vy, float gravity, float damage){
        this.gravity = gravity;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.damage = damage;
    }

    @Override
    public float getDamage() {
        return this.damage;
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
