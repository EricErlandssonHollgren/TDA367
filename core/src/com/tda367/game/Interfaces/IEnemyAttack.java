package Interfaces;

import Model.Entity;
import Model.Tower;

public interface IEnemyAttack {

    float getX();
    float getY();

    float getWidth();
    float getHeight();

    void move();
    void fireAttackAtPlayer(Entity player);
    void fireAttackAtTower(Tower tower);
}
