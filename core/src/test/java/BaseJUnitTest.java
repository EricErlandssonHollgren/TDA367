import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing that the base has a location, health value and contains a turret upon building a turret.
 */

public class BaseJUnitTest {

    @Test
    public void testBaseHasSpecifiedLocation() {
        Base base1 = new Base(0,1,1,0);
        assertEquals(base1.getPositionX(), 1);
        assertEquals(base1.getPositionY(), 1);
    }

    @Test
    public void testBaseHasSpecifiedHealth() {
        Base base2 = new Base(100, 0,0, 0);
        assertEquals(100, base2.getHealth());
    }

    @Test
    public void testBaseContainsSpecifiedTurret() {
        Base base3 = new Base(0,0,0,1);
        Turret turret = new Turret(0,0);
        base3.buildTurret(turret);
        assertTrue(base3.getTurrets().contains(turret));
    }


}