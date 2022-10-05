package Model;

import Interfaces.IEntity;
import Interfaces.IProjectile;

import java.util.ArrayList;
import java.util.List;

public class EntityHolder {
    List<IEntity> entities;
    List<IProjectile> projectiles;
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
    public void addEntity(IEntity entity){
        //In factories add entities to this list
        entities.add(entity);
    }
    public void addProjectile(IProjectile projectile){
        projectiles.add(projectile);
    }
}
