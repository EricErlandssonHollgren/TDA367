package Model.Enemy.Enemies;

import Interfaces.IEnemy;
import Model.Vector;

/**
 * First instance of an enemy to be rendered on the screen.
 * Values are currently placeholders, will change later.
 */
public class Enemy1 implements IEnemy {

    private static final int worth = 5;
    private static int HP = 5;
    private Vector position = new Vector(1560,0);

    public Enemy1(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }

    @Override
    public float getX() {
        return position.x;
    }

    @Override
    public float getY() {
        return position.y;
    }

    /**
     * Changes the position of the enemy to create movement.
     * speed: How fast the enemy is moving, higher number equals higher speed
     */
    @Override
    public void move() {
        float speed = (float) 0.5;
        position.setLocation(position.x-speed, position.y);
    }
}
