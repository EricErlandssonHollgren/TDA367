package Interfaces;

import Model.Entity;

public interface IProjectile {
    /**
     * Deals damage to the enemy in the parameter corresponding to the projectiles damage
     * @param enemy that should receive damage
     */
    void projectileAttack(Entity enemy);
    /**
     * Getter for position X
     * @return position X
     */
    float getX();
    /**
     * Getter for position Y
     * @return position Y
     */
    float getY();
    /**
     * Getter for a potential texture that is used
     * @return String with path to a texture
     */
    String getTexturePath();
    /**
     * Getter for radius
     * @return radius
     */
    float getRadius();
    /**
     * Moves the projectile according to the velocities
     */
    void move();
}
