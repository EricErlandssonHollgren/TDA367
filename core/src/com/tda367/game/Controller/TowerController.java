package Controller;

import Interfaces.IObservers;
import Model.ActionEnum;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonatan Jageklint <jonatan.jage@gmail.com>
 * @author Eric Erlandsson Hollgren <eric.e.hollgren@gmail.com>
 */

public class TowerController {
    private List<IObservers> observers;

    //A constructor for the controller that holds a list of observers that calls them to handle different actions.
    public TowerController(){
        observers = new ArrayList<>();
    }

    //Adds an observer to this controller.
    public void addSubscribers(IObservers observer){
        observers.add(observer);
    }

    //Tells tower to upgrade itself.
    public void upgradeTower() {
            for (IObservers o : observers) {
                o.actionHandle(ActionEnum.UPGRADE);
            }
    }

    //Tells tower to build a turret.
    public void buildTurret() {
            for (IObservers o : observers) {
                o.actionHandle(ActionEnum.BUILD);
            }

    }
    public void sellTurret() {
        for (IObservers o : observers) {
                o.actionHandle(ActionEnum.SELL);
        }
    }
}


