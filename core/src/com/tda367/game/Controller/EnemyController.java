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

    public void addSubscribers(IObservers observer){
        observers.add(observer);
    }


    public void updateEnemy(Entity enemy){
        for (IObservers o: observers){
            EntityHolder.getInstance().removeEntity(enemy);
            o.actionHandle(ActionEnum.DYING);
        }

    }
}
