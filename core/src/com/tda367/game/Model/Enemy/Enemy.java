package Model.Enemy;

import com.badlogic.gdx.math.Vector2;

/**
 * All methods and parameters that an Enemy might need.
 */


public abstract class Enemy {

    private int worth;
    private int HP;

    private Vector2 positionX;

    private Vector2 positionY;

    private String projectile;

    private String spritePath;

    /**
     *
     * @param worth = is what the enemy is "worth". int will be transferred to the player when the enemy has been killed
     * @param HP = every enemy has a number of "health points" that will decrease as it is being attacked.

     */
    public Enemy(int worth, int HP, String projectile, String spritePath, Vector2 positionX, Vector2 positionY) {
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

    public Vector2 getPositionX() {
        return positionX;
    }

    public Vector2 getPositionY() {
        return positionY;
    }
}
