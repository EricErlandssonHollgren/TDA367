package Model;

import Interfaces.IProjectile;

public class Cannonball implements IProjectile {
    private float x,y,vx,vy,gravity, radius;
    private final int damage;
    private String texturePath;

    /**
     * Constructor for Cannonball
     * @param x horizontal position
     * @param y vertical position
     * @param vx horizontal velocity
     * @param vy vertical velocity
     * @param gravity vertical gravity
     * @param damage damage done by projectile
     * @param radius radius of the projectile
     */
    public Cannonball(float x, float y, float vx, float vy, float gravity, int damage, float radius){
        this.gravity = gravity;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.damage = damage;
    }

    /**
     * Setter for a potential texture to be used
     * @param path
     */
    public void setTexturePath(String path){
        this.texturePath = path;
    }

    @Override
    public String getTexturePath(){
        return this.texturePath;
    }

    @Override
    public void projectileAttack(Entity enemy) {
        enemy.takeDamage(this.damage);
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
    public float getRadius() {
        return this.radius;
    }

    @Override
    public void move(){
        vy += gravity;
        x += vx;
        y += vy;
    }
}
