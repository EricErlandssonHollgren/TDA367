package java;
import com.tda367.game.Model.Base;
import com.tda367.game.Model.Turret;
import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing that the base has a location, health value and contains a turret upon building a turret.
 */

public class baseTest {

    @Test
    public void testLocation() {
        Base base1 = new Base(0,1,1,0);
        assertEquals(base1.getPositionX(), 1);
        assertEquals(base1.getPositionY(), 1);
    }

    @Test
    public void testHealth() {
        Base base2 = new Base(100, 0,0, 0);
        assertTrue(base2.getHealth() == 100);
    }

    @Test
    public void testTurrets() {
        Base base3 = new Base(0,0,0,1);
        Turret turret = new Turret(0,0);
        base3.buildTurret(turret);
        assertTrue(base3.getTurrets().contains(turret));
    }


}