package Controller;

import Interfaces.IObservers;
import Model.ActionEnum;
import com.badlogic.gdx.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TowerController {
    private List<IObservers> observers;

    //A constructor for the controller that holds a list of observers that calls them to handle different actions.
    public TowerController() {
        observers = new ArrayList<>();
        towerButtons = new ArrayList<>();
        upgrade = new Button();
    }

    //Adds an observer to this controller.
    public void addSubscribers(IObservers observer) {
        observers.add(observer);
    }

    public void upgradeTower() {
        for (IObservers o : observers) {
            o.actionHandle(ActionEnum.UPGRADE);
        }
    }

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

    //Tells tower to upgrade a specific turret.
    public void upgradeTurret(int i) {
        if (i == 1) {
            for (IObservers o : observers) {
                o.actionHandle(ActionEnum.UPGRADETURRET1);
            }
        } else if (i == 2) {
            for (IObservers o : observers) {
                o.actionHandle(ActionEnum.UPGRADETURRET2);
            }
        }
    }


}
