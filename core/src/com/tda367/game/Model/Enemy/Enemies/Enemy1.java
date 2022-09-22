package Model.Enemy.Enemies;

import Model.Enemy.Enemy;
import com.badlogic.gdx.math.Vector2;

import java.awt.geom.Point2D;

/**
 * First instance of an enemy to be rendered on the screen.
 * Values are currently placeholders, will change later.
 */
public class Enemy1 extends Enemy {

    private static final int worth = 5;
    private static final int HP = 5;
    private static final String projectile = "bomb";
    private static final String spritePath = "koopaTroopa.png";
    private static final Point2D positionX = new Point2D.Float(230, 0);
    private static final Point2D positionY = new Point2D.Float(0, 0);

    public Enemy1() {
        super(worth, HP, projectile, spritePath, positionX, positionY);
    }

    public String getSpritePath() {
        return spritePath;
    }
}
