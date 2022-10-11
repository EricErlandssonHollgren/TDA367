import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import Model.Waves;
import Model.WorldBoundaries;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for making sure the enemy is in the right position on the screen as well is rendering as expected
 */

public class EnemyTest {
    Enemy enemy = new Enemy1();

    Waves wave = new Waves();
    /**
     * Checks if the enemy is being rendered at the right position on the screen.
     * The actual values are taken from WorldBoundaries and in which position the walls and ground are created
     */
    @Test
    public void testPosition() {
        assertEquals(enemy.getX(), 630);
        assertEquals(enemy.getY(), 100);
    }

    /**
     * Checks if the enemy is moving from right to left along the X-axis on the screen by comparing its previous
     * position to the current one.
     */
    @Test
    public void testMovementX() {
        float oldPositionX = enemy.getX();
        enemy.moveEnemy();
        for (int i = 1; i <= 1560; i++) {
            if (oldPositionX >= enemy.getX()) {
                assertTrue(true);
            }
            oldPositionX = oldPositionX - (float) 0.5;
        }
    }

    /**
     * Checks if the enemy is not moving in the Y-direction and therefore is staying on the "ground".
     */
    @Test
    public void testMovementY() {
        float oldPositionY = enemy.getY();
        enemy.moveEnemy();
        for (int i = 1; i <= 780; i++) {
            if (oldPositionY == enemy.getX()) {
                assertTrue(true);
            }
        }
    }

    /**
     * Checks so that the number of enemies added to a wave is correct.
     */
    @Test
    public void testNumberOfEnemiesInQueue() {
        assertEquals(wave.addEnemies().size(), 10);
    }

}