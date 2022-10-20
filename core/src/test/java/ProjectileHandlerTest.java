import Interfaces.IProjectile;
import Model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectileHandlerTest {
    private static EntityHolder eh;
    private static CollisionDetection cd;
    private static GameTimer timer;
    private static ProjectileHandler ph;

    @BeforeAll
    public static void init(){
        eh = EntityHolder.getInstance();
        cd = CollisionDetection.getInstance();
        timer = GameTimer.GetInstance();
        ph = new ProjectileHandler(eh,cd,timer);
    }

    @Test
    public void getAllProjectilesTest(){
        ProjectileFactory.createCannonball(50,50,50,50,50);
        assertEquals(1,ph.getCurrentProjectiles().size());
    }

    @Test
    public void updateProjectilesTest(){
        IProjectile p = ProjectileFactory.createCannonball(1,1,1,1,1);

    }
}
