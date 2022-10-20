import Interfaces.IProjectile;
import Model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
    public void ProjectilesAreBeingRemovedAfterUpdating(){
        IProjectile p = ProjectileFactory.createCannonball(10,10,10,10,10);
        ProjectileHandler handler = new ProjectileHandler(EntityHolder.getInstance(), CollisionDetection.getInstance(),GameTimer.GetInstance());

        EntityHolder.getInstance().addProjectile(p);
        List<IProjectile> projectileGround = cd.checkCollisionProjectileGround();
        Map<Entity,IProjectile> projectileEnemy = cd.checkCollisionProjectileAndEnemy();

        cd.checkCollisionProjectileGround();
        cd.checkCollisionProjectileAndEnemy();
        handler.updateProjectiles(projectileEnemy, projectileGround);

        assertFalse(EntityHolder.getInstance().getProjectiles().contains(p));


    }
}
