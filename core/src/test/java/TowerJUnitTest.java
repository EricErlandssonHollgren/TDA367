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
        assertEquals(tower1.getPositionY(), 100);
    }

    @Test
    public void testTowerHasSpecifiedHealth() {
        Tower tower2 = new Tower();
        assertEquals(500, tower2.getHealth());
    }

    @Test
    public void testTowerContainsSpecifiedTurret() {
        Goldhandler gold = new Goldhandler();
        gold.handleRequest(new Request(HandlerItemDefiners.ADDGOLD, 1000));
        Tower tower3 = new Tower(gold);
        Turret turret1 = new Turret();
        tower3.buildTurret(turret1);
        assertTrue(tower3.getTurrets().contains(turret1));
    }

    @Test
    public void testTowerUpgrades(){
        Goldhandler gold2 = new Goldhandler();
        gold2.handleRequest(new Request(HandlerItemDefiners.ADDGOLD, 3000));
        Tower tower4 = new Tower(gold2);
        tower4.upgrade();
        Turret turret1 = new Turret();
        Turret turret2 = new Turret();
        tower4.buildTurret(turret1);
        tower4.buildTurret(turret2);
        assertEquals(2, tower4.getTurrets().size());
        assertEquals(700, tower4.getHealth());
    }
    @Test
    public void testTowerUpgradesTurret(){
        Goldhandler gold3 = new Goldhandler();
        gold3.handleRequest(new Request(HandlerItemDefiners.ADDGOLD, 7000));
        Tower tower4 = new Tower(gold3);
        tower4.upgrade();
        Turret turret1 = new Turret();
        Turret turret2 = new Turret();
        tower4.buildTurret(turret1);
        tower4.upgradeTurret(0);
        tower4.buildTurret(turret2);
        tower4.upgradeTurret(1);
        assertEquals(tower4.getTurrets().get(0).getLevel(), 2);
        assertEquals(tower4.getTurrets().get(1).getLevel(), 2);
    }


}