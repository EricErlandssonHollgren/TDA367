import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for making sure the enemy is in the right position on the screen as well is rendering as expected
 */

public class testEnemy {

    @Test
    public void testPosition() {
        Enemy enemy = new Enemy1();
        assertEquals(enemy.getPositionX(), new Vector2(800,0));
        assertEquals(enemy.getPositionY(), new Vector2(0,0));
    }

    @Test
    public void testRendering() {
        Enemy enemy = new Enemy1();
        assertTrue(enemy.getSpritePath() == "koopaTroopa.png");
    }

}