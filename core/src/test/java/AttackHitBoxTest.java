import Model.AttackHitbox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AttackHitBoxTest {

    private AttackHitbox ah;

    @BeforeEach
    public void init(){
        ah = new AttackHitbox(0,0);
    }

    @Test
    public void getYTest(){
        assertEquals(0,ah.getY());
    }

    @Test
    public void getXTest(){
        assertEquals(0,ah.getX());
    }

    @Test
    public void getHeightTest(){
        assertEquals(37,ah.getHeight());
    }

    @Test
    public void getWidthTest(){
        assertEquals(120,ah.getWidth());
    }

    @Test
    public void setYTest(){
        ah.setY(10);
        assertEquals(10,ah.getY());
    }
}
