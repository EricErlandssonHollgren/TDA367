package Model;

import Interfaces.IProjectile;

public class ProjectileFactory {
    public static IProjectile createCannonball(float x, float y, float vx, float vy, float gravity){
        return new Cannonball(x, y, vx, vy, "Cannonball.png", gravity);
    }
}
