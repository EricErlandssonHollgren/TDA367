package Model;

import Interfaces.IEnemyAttack;
import Interfaces.IProjectile;

import java.util.ArrayList;
import java.util.List;

public class EntityHolder {
    private List<Entity> entities;
    private List<IProjectile> projectiles;
    private List<IEnemyAttack> enemyAttacks;
    private static EntityHolder instance;

    /**
     * Instantiate the arraylists for entities, projectiles and enemyAttacks,
     */
    public EntityHolder(){
        entities = new ArrayList<>();
        projectiles = new ArrayList<>();
        enemyAttacks = new ArrayList<>();
    }

    /**
     * EntityHolder gets the instance of an entityHolder
     * @return instance
     */
    public static EntityHolder getInstance(){
        if(instance == null){
            instance = new EntityHolder();
        }
        return instance;
    }

    /**
     * Adds entities to the list of entities
     * @param entity could either be a player or enemy
     */
    public void addEntity(Entity entity){
        entities.add(entity);
    }

    /**
     * Removes entities from the list of entities
     * @param entity could either be a player or enemy
     */
    public void removeEntity(Entity entity){
        entities.remove(entity);
    }

    /**
     * Gets a list of projectiles
     * @return projectiles
     */
    public List<IProjectile> getProjectiles(){
        return this.projectiles;
    }

    /**
     * Gets a list of enemyAttacks
     * @return enemyAttacks
     */
    public List<IEnemyAttack> getEnemyAttacks(){
        return this.enemyAttacks;
    }

    /**
     * Adds a fireattack to the enemyAttack list
     * @param attack is being added
     */
    public void addFireAttack(IEnemyAttack attack){
        enemyAttacks.add(attack);
    }

    /**
     * Removing fireattack from enemyAttack list
     * @param attack is being removed
     */

    public void removeFireAttack(IEnemyAttack attack){
        enemyAttacks.remove(attack);
    }

    /**
     * A list of entity is being fetched
     * @return entities of this class
     */
    public List<Entity> getEntities(){
        return this.entities;
    }

    /**
     * Adding a projectile to a list
     * @param projectile is of IProjectile
     */
    public void addProjectile(IProjectile projectile){
        projectiles.add(projectile);
    }

    /**
     * Removing a projectile to a list
     * @param projectile is of IProjectile
     */
    public void removeProjectile(IProjectile projectile){
        projectiles.remove(projectile);
    }

    /**
     * Clear the arraylists for entities, projectiles och enemyAttacks.
     */
    public void clearAll() {
        entities = new ArrayList<>();
        projectiles = new ArrayList<>();
        enemyAttacks = new ArrayList<>();
    }

}
