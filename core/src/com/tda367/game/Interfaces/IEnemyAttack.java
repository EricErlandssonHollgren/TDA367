package Interfaces;

import Model.Entity;
import Model.Tower;

public interface IEnemyAttack {

    float getX();
    float getY();

    float getWidth();
    float getHeight();
    int getDamage();
    void move(double velocity);
    void fireAttackAtPlayer(Entity player);
    void fireAttackAtTower(Tower tower);
}
