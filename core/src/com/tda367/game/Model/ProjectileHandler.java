package Model;

import Interfaces.IProjectile;

import java.util.List;
import java.util.Map;

public class ProjectileHandler {

    private EntityHolder entityHolder;

    /**
     * Constructor for projectileHandler
     * @param entityHolder instance of the entityHolder
     */
    public ProjectileHandler(EntityHolder entityHolder){
        this.entityHolder = entityHolder;
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
