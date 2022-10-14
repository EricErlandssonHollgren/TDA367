package Controller;

import Interfaces.IObservers;
import Model.*;
import Model.Enemy.Enemy;

import javax.swing.border.SoftBevelBorder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EnemyController {

    private List<IObservers> observers = new ArrayList<>();
    private EntityHolder entityHolder;
    private CollisionDetection collisionDetection;
    private GameTimer timer;
    private boolean hasSpawned;

    public EnemyController(EntityHolder entityHolder, CollisionDetection collisionDetection, GameTimer timer){
        this.hasSpawned = false;
        this.entityHolder = entityHolder;
        this.timer = timer;
        this.collisionDetection = collisionDetection;

    }

    public void addSubscribers(IObservers observer){
        observers.add(observer);
    }

    public List<Entity> getCurrentEnemies(){
        return entityHolder.getEnemies();
    }

    public void updateEnemy(Map<Entity, Boolean> collisions){
        //TODO: Fixa här för att uppdatera enemy-listan
        for (IObservers o: observers) {
            o.actionHandle(ActionEnum.DYING);
        }
        for(Entity e: getCurrentEnemies()){
           if(e instanceof Enemy){
               entityHolder.removeEntity(e);
           }
        }
    }
}
