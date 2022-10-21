import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing that the base has a level, location, health value and contains a turret upon building a turret.
 * Also testing that the tower upgrades, and can handle calling upon a turret to upgrade.
 */

public class TowerJUnitTest {

    @Test
    public void testTowerHasLevel() {
        Tower tower1 = new Tower(new Goldhandler());
        assertEquals(1, tower1.getLevel());
    }

    @Test
    public void testTowerHasSpecifiedLocation() {
        Tower tower2 = new Tower(new Goldhandler());
        assertEquals(tower2.getPositionX(), 0);
        assertEquals(tower2.getPositionY(), 100);
    }

    @Test
    public void testTowerHasSpecifiedHealth() {
        Tower tower3 = new Tower(new Goldhandler());
        assertEquals(400, tower3.getHealth());
    }

    @Test
    public void testTowerHasWidth() {
        Tower tower4 = new Tower(new Goldhandler());
        assertEquals(100, tower4.getWidth());
    }

    @Test
    public void testTowerContainsATurret() {
        Goldhandler gold1 = new Goldhandler();
        gold1.handleRequest(new Request(HandlerItemDefiners.GOLD, 1000));
        Tower tower5 = new Tower(gold1);
        tower5.actionHandle(ActionEnum.BUILD);
        assertEquals(1, tower5.getTurrets().size());
    }

    @Test
    public void testTowerUpgrades(){
        Goldhandler gold2 = new Goldhandler();
        gold2.handleRequest(new Request(HandlerItemDefiners.GOLD, 5000));
        Tower tower6 = new Tower(gold2);
        tower6.actionHandle(ActionEnum.UPGRADE);
        tower6.actionHandle(ActionEnum.BUILD);
        tower6.actionHandle(ActionEnum.BUILD);
        assertEquals(2, tower6.getLevel());
        assertEquals(2, tower6.getTurrets().size());
        assertEquals(600, tower6.getHealth());
    }

    @Test
    public void testTowerUpgradesTurret(){
        Goldhandler gold3 = new Goldhandler();
        gold3.handleRequest(new Request(HandlerItemDefiners.GOLD, 7000));
        Tower tower7 = new Tower(gold3);
        tower7.actionHandle(ActionEnum.UPGRADE);
        tower7.actionHandle(ActionEnum.BUILD);
        tower7.actionHandle(ActionEnum.UPGRADETURRET1);
        tower7.actionHandle(ActionEnum.BUILD);
        tower7.actionHandle(ActionEnum.UPGRADETURRET2);
        assertEquals(tower7.getTurrets().get(0).getLevel(), 2);
        assertEquals(tower7.getTurrets().get(1).getLevel(), 2);
    }

    @Test
    public void testTowerFiresTurrets(){
        Goldhandler gold4 = new Goldhandler();
        gold4.handleRequest(new Request(HandlerItemDefiners.GOLD, 5000));
        Tower tower8 = new Tower(gold4);
        Turret turret = new Turret();
        tower8.buildTurret(turret);
        GameTimer testTimer = GameTimer.GetInstance();
        testTimer.resetTimer();
        testTimer.UpdateTime(5);
        tower8.fireTurrets();
        assertTrue(turret.getHasSpawned());
    }
}