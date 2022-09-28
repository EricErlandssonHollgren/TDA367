import Interfaces.IEnemy;
import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import Model.Vector;
import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for making sure the enemy is in the right position on the screen as well is rendering as expected
 */

public class testEnemy {
    IEnemy enemy = new Enemy1(new Vector(800,0), new Vector(0,0));

    @Test
    public void testPosition() {
        assertEquals(enemy.getX(), new Vector2(800,0));
        assertEquals(enemy.getY(), new Vector2(0,0));
    }

    @Test
    public void testRendering() {
        assertTrue(enemy.getTexturePath() == "koopaTroopa.png");
    }

}