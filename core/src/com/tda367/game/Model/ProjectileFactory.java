package Model;

import Interfaces.IProjectile;

public class ProjectileFactory {
    public static IProjectile createCannonball(float x, float y, float vx, float vy, float damage){
        Cannonball c = new Cannonball(x, y, vx, vy, -0.5f, damage, 16);
        EntityHolder.getInstance().addProjectile(c);
        return c;
    }
}
