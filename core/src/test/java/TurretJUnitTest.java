import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing that the turret has a level, damage and a shootingSpeed.
 * Also testing that the tower upgrades, and can handle calling upon a turret to upgrade.
 */
public class TurretJUnitTest {
    @Test
    public void testTurretHasLevel() {
        Turret turret = new Turret();
        assertEquals(1, turret.getLevel());
    }

    @Test
    public void testTurretHasDamage() {
        Turret turret1 = new Turret();
        assertEquals(10, turret1.getDamage());
    }

    @Test
    public void testTurretHasShootingSpeed() {
        Turret turret2 = new Turret();
        assertEquals(5, turret2.getShootingSpeed());
    }

    @Test
    public void testTurretUpgrades(){
        Turret turret3 = new Turret();
        turret3.upgrade();
        assertEquals(2, turret3.getLevel());
        assertEquals(30, turret3.getDamage());
        assertEquals(4, turret3.getShootingSpeed());
    }
}
