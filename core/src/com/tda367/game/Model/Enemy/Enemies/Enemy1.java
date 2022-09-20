package Model.Enemy.Enemies;

import Model.Enemy.Enemy;

/**
 * First instance of an enemy to be rendered on the screen.
 * Values are currently placeholders, will change later.
 */
public class Enemy1 extends Enemy {

    private static final int worth = 5;
    private static final int HP = 5;
    private static final String projectile = "bomb";
    private static final String spritePath = "koopaTroopa.png";
    private static final float positionX = 800;
    private static final float positionY = 0;

    public Enemy1() {
        super(worth, HP, projectile, spritePath, positionX, positionY);
    }

    public String getSpritePath() {
        return spritePath;
    }
}
