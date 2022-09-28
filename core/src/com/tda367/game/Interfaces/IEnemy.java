package Interfaces;

import Model.Vector;

public interface IEnemy {
    String getTexturePath();
    Vector getX();
    Vector getY();
    void move();
}
