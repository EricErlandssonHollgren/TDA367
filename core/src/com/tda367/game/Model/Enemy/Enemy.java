package Model.Enemy;

import com.badlogic.gdx.math.Vector2;

import java.awt.geom.Point2D;

/**
 * All methods and parameters that an Enemy might need.
 */


public abstract class Enemy {

    private int worth;
    private int HP;

    private Point2D positionX;

    private Point2D positionY;

    private String projectile;

    private String spritePath;

    /**
     *
     * @param worth = is what the enemy is "worth". int will be transferred to the player when the enemy has been killed
     * @param HP = every enemy has a number of "health points" that will decrease as it is being attacked.

     */
    public Enemy(int worth, int HP, String projectile, String spritePath, Point2D positionX, Point2D positionY) {
        this.worth = worth;
        this.HP = HP;
        this.projectile = projectile;
        this.spritePath = spritePath;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getWorth() {
        return worth;
    }

    public int getHP() {
        return HP;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public Point2D getPositionX() {
        return positionX;
    }

    public Point2D getPositionY() {
        return positionY;
    }
}
