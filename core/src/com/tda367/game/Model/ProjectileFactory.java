package Model;

import Interfaces.IProjectile;

public class ProjectileFactory {

    /**
     * Creates a cannonball and adds it to the list of projectiles in Entity holder
     * @param x the x-position for the projectile
     * @param y the y-position for the projectile
     * @param vx the velocity along the y-axis
     * @param vy the velocity along the x-axis
     * @param damage the damage the projectile will do to the object it hits
     * @return a new cannonball
     */
    public static IProjectile createCannonball(float x, float y, float vx, float vy, int damage){
        Cannonball c = new Cannonball(x, y, vx, vy, -0.5f, damage, 16);
        c.setTexturePath("Cannonball.png");
        EntityHolder.getInstance().addProjectile(c);
        return c;
    }
}
