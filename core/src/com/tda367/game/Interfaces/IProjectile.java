package Interfaces;

import Model.Entity;

public interface IProjectile {
    void projectileAttack(Entity enemy);
    float getX();
    float getY();
    float getRadius();
    void move();
}
