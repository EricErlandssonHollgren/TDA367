import Model.HealthBar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HealthBarTest {
    HealthBar healthBar = new HealthBar(10,20,200,24,24);

    @Test
    public void testPosition() {
        assertEquals(healthBar.getPositionX(), 10+12);
        assertEquals(healthBar.getPositionY(), 20+24);
    }

    @Test
    public void testHealth() {
        assertEquals(healthBar.getHealth(), 200);
    }

    @Test
    public void testHealthProcentage() {
        assertEquals(healthBar.getHealthWidth(), 1);
    }
}
