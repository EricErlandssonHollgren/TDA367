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
        Tower tower = new Tower(new Goldhandler());
        assertEquals(1, tower.getLevel());
    }

    @Test
    public void testTowerHasSpecifiedLocation() {
        Tower tower1 = new Tower(new Goldhandler());
        assertEquals(tower1.getPositionX(), 0);
        assertEquals(tower1.getPositionY(), 100);
    }

    @Test
    public void testTowerHasSpecifiedHealth() {
        Tower tower2 = new Tower(new Goldhandler());
        assertEquals(500, tower2.getHealth());
    }

    @Test
    public void testTowerContainsATurret() {
        Goldhandler gold = new Goldhandler();
        gold.handleRequest(new Request(HandlerItemDefiners.GOLD, 1000));
        Tower tower3 = new Tower(gold);
        tower3.actionHandle(ActionEnum.BUILD);
        assertEquals(1, tower3.getTurrets().size());
    }

    @Test
    public void testTowerUpgrades(){
        Goldhandler gold2 = new Goldhandler();
        gold2.handleRequest(new Request(HandlerItemDefiners.GOLD, 5000));
        Tower tower4 = new Tower(gold2);
        tower4.actionHandle(ActionEnum.UPGRADE);
        tower4.actionHandle(ActionEnum.BUILD);
        tower4.actionHandle(ActionEnum.BUILD);
        assertEquals(2, tower4.getLevel());
        assertEquals(2, tower4.getTurrets().size());
        assertEquals(700, tower4.getHealth());
    }
    @Test
    public void testTowerUpgradesTurret(){
        Goldhandler gold3 = new Goldhandler();
        gold3.handleRequest(new Request(HandlerItemDefiners.GOLD, 7000));
        Tower tower5 = new Tower(gold3);
        tower5.actionHandle(ActionEnum.UPGRADE);
        tower5.actionHandle(ActionEnum.BUILD);
        tower5.actionHandle(ActionEnum.UPGRADETURRET1);
        tower5.actionHandle(ActionEnum.BUILD);
        tower5.actionHandle(ActionEnum.UPGRADETURRET2);
        assertEquals(tower5.getTurrets().get(0).getLevel(), 2);
        assertEquals(tower5.getTurrets().get(1).getLevel(), 2);
    }


}