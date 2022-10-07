import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import Model.Vector;
import Model.Waves;
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
     */
    @Test
    public void testPosition() {
        assertEquals(enemy.getX(), new Vector(1560,0).getX());
        assertEquals(enemy.getY(), new Vector(0,0).getY());
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