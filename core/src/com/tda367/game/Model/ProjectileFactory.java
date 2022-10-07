package Model;

import Interfaces.IProjectile;

public class ProjectileFactory {
    public static IProjectile createCannonball(float x, float y, float vx, float vy, float gravity, float damage){
        Cannonball c = new Cannonball(x, y, vx, vy, gravity, damage, 16);
        EntityHolder.getInstance().addProjectile(c);
        return c;
    }
}
