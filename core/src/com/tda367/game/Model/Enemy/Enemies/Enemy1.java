package Model.Enemy.Enemies;

import Interfaces.IEnemy;
import Model.Enemy.Enemy;
import Model.Vector;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * First instance of an enemy to be rendered on the screen.
 * Values are currently placeholders, will change later.
 */
public class Enemy1 implements IEnemy {

    private static final int worth = 5;
    private static final int HP = 5;
    private static final String texturePath = "koopaTroopa.png";
    private Vector positionX;
    private Vector positionY;

    public Enemy1(Vector x, Vector y) {
        this.positionX = x;
        this.positionY = y;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }

    @Override
    public Vector getX() {
        return positionX;
    }

    @Override
    public Vector getY() {
        return positionY;
    }

    /**
     * Changes the position of the enemy to create movement.
     * speed: How fast the enemy is moving, higher number equals higher speed
     */
    @Override
    public void move() {
        double speed = 0.5;
        positionX.setLocation(positionX.getX()-speed, positionY.getY());
    }
}
