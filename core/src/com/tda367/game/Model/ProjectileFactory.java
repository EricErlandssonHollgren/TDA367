package Model;

import Interfaces.IProjectile;

public class ProjectileFactory {
    public static IProjectile createCannonball(float x, float y, float vx, float vy, float gravity, float damage){
        return new Cannonball(x, y, vx, vy, gravity, damage);
    }
}
