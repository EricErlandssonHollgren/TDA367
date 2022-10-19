package Model;

import Interfaces.IEnemyAttack;
import Interfaces.IProjectile;

import java.util.ArrayList;
import java.util.List;

public class EntityHolder {
    List<Entity> entities;
    private List<IProjectile> projectiles;
    private List<IEnemyAttack> enemyAttacks;

    private static EntityHolder instance;
    private EntityHolder(){
        entities = new ArrayList<>();
        projectiles = new ArrayList<>();
        enemyAttacks = new ArrayList<>();
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

    public List<IEnemyAttack> getEnemyAttacks(){
        return this.enemyAttacks;
    }
    public void addFireAttack(IEnemyAttack attack){
        enemyAttacks.add(attack);
    }

    public void removeFireAttack(IEnemyAttack attack){
        enemyAttacks.remove(attack);
    }

    public List<Entity> getEntities(){
        return this.entities;
    }

    public void addProjectile(IProjectile projectile){
        projectiles.add(projectile);
    }
    public void removeProjectile(IProjectile projectile){
        projectiles.remove(projectile);
    }

}
