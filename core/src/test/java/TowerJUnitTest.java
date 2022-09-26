import Model.Tower.*;
import Model.Tower.Towers.*;
import Model.Turret.*;
import Model.Turret.Turrets.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing that the base has a location, health value and contains a turret upon building a turret.
 */

public class TowerJUnitTest {

    @Test
    public void testTowerHasSpecifiedLocation() {
        Tower tower1 = new basicTower(0,0);
        assertEquals(tower1.getPositionX(), 0);
        assertEquals(tower1.getPositionY(), 0);
    }

    @Test
    public void testTowerHasSpecifiedHealth() {
        Tower tower2 = new basicTower(100,0);
        assertEquals(100, tower2.getHealth());
    }

    @Test
    public void testTowerContainsSpecifiedTurret() {
        Tower tower3 = new basicTower(0,2);
        Turret turret1 = TurretFactory.createBasicTurret();
        Turret turret2 = TurretFactory.createAdvTurret();
        tower3.buildTurret(turret1);
        tower3.buildTurret(turret2);
        assertTrue(tower3.getTurrets().contains(turret1));
        assertTrue(tower3.getTurrets().contains(turret2));
    }


}