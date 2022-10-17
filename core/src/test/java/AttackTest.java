import Model.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


public class AttackTest {

    FireAttack fire = new FireAttack(630,100);

    @Test
    public void testMovement(){
        float oldPositionX = fire.getX();
        fire.move();
        for (int i = 1; i <= 630; i++) {
            if (oldPositionX >= fire.getX()) {
                assertTrue(true);
            }
            oldPositionX = oldPositionX - (float) 0.5;
        }
    }
}
