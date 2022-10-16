package Model;

import Interfaces.IProjectile;

import java.util.ArrayList;
import java.util.List;

public class EntityHolder {
    List<Entity> entities;
    private List<IProjectile> projectiles;

    private List<Enemy> enemies;

    private static EntityHolder instance;
    private EntityHolder(){
        entities = new ArrayList<>();
        projectiles = new ArrayList<>();
        enemies = new ArrayList<>();
    }
    public static EntityHolder getInstance(){
        if(instance == null){
            instance = new EntityHolder();
        }
        return instance;
    }
    public void addEntity(Entity entity){
        entities.add(entity);
    }
    public void removeEntity(Entity entity){
        entities.remove(entity);
    }
    public List<IProjectile> getProjectiles(){
        return this.projectiles;
    }

    public void addProjectile(IProjectile projectile){
        projectiles.add(projectile);
    }
    public void removeProjectile(IProjectile projectile){
        projectiles.remove(projectile);
    }

}
