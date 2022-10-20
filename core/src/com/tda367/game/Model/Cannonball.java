package Model;

import Interfaces.IProjectile;

public class Cannonball implements IProjectile {
    private float x,y,vx,vy,gravity, radius;
    private final int damage;
    private String texturePath;

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

    /**
     * Getter for a potential texture that is used
     * @return String with path to a texture
     */
    public String getTexturePath(){
        return this.texturePath;
    }

    /**
     * Deals damage to the enemy in the parameter corresponding to the projectiles damage
     * @param enemy that should receive damage
     */
    @Override
    public void projectileAttack(Entity enemy) {
        enemy.takeDamage(this.damage);
    }

    /**
     * Getter for position X
     * @return float with position X
     */
    @Override
    public float getX(){
        return this.x;
    }
    /**
     * Getter for position Y
     * @return float with position Y
     */
    @Override
    public float getY(){
        return this.y;
    }
    /**
     * Getter for radius
     * @return float with radius
     */
    @Override
    public float getRadius() {
        return this.radius;
    }

    /**
     * Moves the projectile according to the velocities
     */
    @Override
    public void move(){
        vy += gravity;
        x += vx;
        y += vy;
    }
}
