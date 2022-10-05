package Model.Enemy.Enemies;

import Interfaces.IEnemy;
import Model.Vector;

/**
 * First instance of an enemy to be rendered on the screen.
 * Values are currently placeholders, will change later.
 */
public class Enemy1 implements IEnemy {

    private final int worth = 5;
    private int HP = 5;
    private Vector position;

    public Enemy1() {
        this.position = new Vector(1560,0);
    }

    @Override
    public float getX() {
        return position.getX();
    }

    @Override
    public float getY() {
        return position.getY();
    }

    /**
     * Changes the position of the enemy to create movement.
     * speed: How fast the enemy is moving, higher number equals higher speed
     */
    @Override
    public void move() {
        double speed = 0.5;
        position.setLocation(position.getX()-speed, position.getY());
    }
}
