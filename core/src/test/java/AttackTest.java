import Model.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


public class AttackTest {

    FireAttack fire = new FireAttack(630,100);


    /**
     * Checks if the fireAttack is moving from right to left along the X-axis on the screen by comparing its previous
     * position to the current one.
     */
    @Test
    public void testMovementX() {
        float posX = fire.getX();
        fire.move();
        assertTrue(fire.getX() < posX);
    }


    /**
     * Checks if the fireAttack is not moving in the Y-direction and therefore is staying on the same level as the enemy.
     */
    @Test
    public void testMovementY() {
        float posY = fire.getY();
        fire.move();
        assertEquals(fire.getY(), posY);
    }
}
