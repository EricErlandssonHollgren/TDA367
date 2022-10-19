package Interfaces;

import Model.Entity;

public interface IProjectile {
    void projectileAttack(Entity enemy);
    float getX();
    float getY();
    String getTexturePath();
    float getRadius();
    void move();
}
