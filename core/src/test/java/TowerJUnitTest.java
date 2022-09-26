import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing that the base has a location, health value and contains a turret upon building a turret.
 */

public class TowerJUnitTest {

    @Test
    public void testTowerHasSpecifiedLocation() {
        Tower tower1 = new Tower(0,1,1,0);
        assertEquals(tower1.getPositionX(), 1);
        assertEquals(tower1.getPositionY(), 1);
    }

    @Test
    public void testTowerHasSpecifiedHealth() {
        Tower tower2 = new Tower(100, 0,0, 0);
        assertEquals(100, tower2.getHealth());
    }

    @Test
    public void testTowerContainsSpecifiedTurret() {
        Tower tower3 = new Tower(0,0,0,1);
        Turret turret = new Turret(0,0);
        tower3.buildTurret(turret);
        assertTrue(tower3.getTurrets().contains(turret));
    }


}