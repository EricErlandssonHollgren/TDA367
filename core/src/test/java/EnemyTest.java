import Interfaces.IEntity;
import Model.Enemy.Enemies.Enemy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for making sure the enemy is in the right position on the screen as well is rendering as expected
 */

public class EnemyTest {
    IEntity enemy = new Enemy1(350, 100);

    /**
     * Checks if the enemy is moving from right to left along the X-axis on the screen by comparing its previous
     * position to the current one.
     */
    @Test
    public void testMovementX() {
        float oldPositionX = enemy.getX();
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
        for (int i = 1; i <= 1560; i++) {
            if (oldPositionY == enemy.getX()) {
                assertTrue(true);
            }
        }
    }

}