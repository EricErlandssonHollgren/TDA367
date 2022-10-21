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

    /**
     * A constructor for TowerController.
     * Holds a list of observers that calls them to handle different actions.
     */
    public TowerController() {observers = new ArrayList<>();}

    /**
     * Adds an observer to this controller.
     */
    public void addSubscribers(IObservers observer) {
        observers.add(observer);
    }

    /**
     * Tells an observing tower to upgrade itself.
     */
    public void upgradeTower() {
        for (IObservers o : observers) {
            o.actionHandle(ActionEnum.UPGRADE);
        }
    }

    /**
     * Tells an observing tower to build a turret.
     */
    public void buildTurret() {
        for (IObservers o : observers) {
            o.actionHandle(ActionEnum.BUILD);
        }

    }

    /**
     * Tells an observing tower to upgrade a specific turret.
     * @param i specifies the turret.
     */
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
