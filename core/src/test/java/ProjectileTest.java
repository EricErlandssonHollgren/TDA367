import Interfaces.IProjectile;
import Model.ProjectileFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectileTest {
    @Test
    public void ProjectileMoveTest(){
        IProjectile p = ProjectileFactory.createCannonball(10,10,10,10,10);
        p.move();
        p.move();
        assertTrue(p.getX() != 10 && p.getY() != 10);
    }

    @Test
    public void cheackTexture(){
        IProjectile p = ProjectileFactory.createCannonball(10,10,10,10,10);
        assertSame( "Cannonball.png", p.getTexturePath());
    }
}
