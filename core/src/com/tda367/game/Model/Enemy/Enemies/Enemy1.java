package Model.Enemy.Enemies;

import Model.Enemy.Enemy;

/**
 * First instance of an enemy to be rendered on the screen.
 * Values are currently placeholders, will change later.
 */
public class Enemy1 extends Enemy {

    static final int worth = 5;
    static final int HP = 5;
    static final String projectile = "bomb";
    static final String spritePath = "koopaTroopa.png";

    static final float positionX = 800;

    static final float positionY = 0;

    public Enemy1() {
        super(worth, HP, projectile, spritePath, positionX, positionY);
    }

    public String getSpritePath() {
        return spritePath;
    }
}
