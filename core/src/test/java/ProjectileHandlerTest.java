import Interfaces.IProjectile;
import Model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectileHandlerTest {
    private static EntityHolder eh;
    private static CollisionDetection cd;
    private static GameTimer timer;
    private static ProjectileHandler ph;

    @BeforeEach
    public void init(){
        eh = EntityHolder.getInstance();
        cd = CollisionDetection.getInstance();
        timer = GameTimer.GetInstance();
        ph = new ProjectileHandler(eh,cd,timer);
        //Resets
        timer.resetTimer();
        for (IProjectile p: eh.getProjectiles()) {
            eh.removeProjectile(p);
        }
    }

    @Test
    public void getAllProjectilesTest(){
        ProjectileFactory.createCannonball(50,50,50,50,50);
        assertEquals(1,ph.getCurrentProjectiles().size());
    }

    @Test
    public void updateProjectilesTest(){
        IProjectile p1 = ProjectileFactory.createCannonball(1,1,1,1,1);
        IProjectile p2 = ProjectileFactory.createCannonball(1,1,1,1,1);

        Map<Entity, IProjectile> input1 = new HashMap<>();
        List<IProjectile> input2 = new ArrayList<>();

        input1.put(new Enemy(1,1,1,null,1),p1);
        input2.add(p2);

        ph.updateProjectiles(input1,input2);

        assertEquals(0,eh.getProjectiles().size());
    }
}
