import Model.Tower;
import Model.Turret;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing that the base has a location, health value and contains a turret upon building a turret.
 */

public class TowerJUnitTest {

    @Test
    public void testTowerHasSpecifiedLocation() {
        Tower tower1 = new Tower();
        assertEquals(tower1.getPositionX(), 0);
        assertEquals(tower1.getPositionY(), 0);
    }

    @Test
    public void testTowerHasSpecifiedHealth() {
        Tower tower2 = new Tower();
        assertEquals(500, tower2.getHealth());
    }

    @Test
    public void testTowerContainsSpecifiedTurret() {
        Tower tower3 = new Tower();
        Turret turret1 = new Turret();
        tower3.buildTurret(turret1);
        assertTrue(tower3.getTurrets().contains(turret1));
    }


}