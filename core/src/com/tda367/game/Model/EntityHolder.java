package Model;

import Interfaces.IProjectile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EntityHolder {
    List<Entity> entities;
    private List<IProjectile> projectiles;

    private static EntityHolder instance;
    private EntityHolder(){
        entities = new ArrayList<>();
        projectiles = new ArrayList<>();
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
