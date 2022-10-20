package Model;

import Interfaces.IProjectile;
import Model.*;

import java.util.List;
import java.util.Map;

public class ProjectileHandler {

    private EntityHolder entityHolder;
    private CollisionDetection collisionDetection;
    private GameTimer timer;
    private boolean hasSpawned;

    /**
     * Constructor for projectileHandler
     * @param entityHolder instance of the entityHolder
     * @param collisionDetection instance of the CollisionDetection
     * @param timer instance of the in game timer
     */
    public ProjectileHandler(EntityHolder entityHolder, CollisionDetection collisionDetection, GameTimer timer){
        this.hasSpawned = false;
        this.entityHolder = entityHolder;
        this.timer = timer;
        this.collisionDetection = collisionDetection;
    }

    /**
     * Gets the list of projectile objects
     * @return List of projectiles
     */
    public List<IProjectile> getCurrentProjectiles(){
        return entityHolder.getProjectiles();
    }

    /**
     * Removes projectiles that hit an enemy or ground, adds projectiles every second.
     * Called every time render() is called.
     * @param collisions
     */
    public void updateProjectiles(Map<Entity,IProjectile> collisions, List<IProjectile> collisionsGround){
        for (IProjectile p: collisions.values()) {
            entityHolder.removeProjectile(p);
        }
        for(IProjectile p : collisionsGround){
            entityHolder.removeProjectile(p);
        }
    }
}
