package Controller;

import Interfaces.IObservers;
import Model.ActionEnum;
import com.badlogic.gdx.*;

import java.util.ArrayList;
import java.util.List;


public class TowerKeyListener {
    List<IObservers> observers = new ArrayList<>();

    public void addSubscribers(IObservers observer){
        observers.add(observer);
    }

    public void upgradeTower() {
        if (Gdx.input.isKeyPressed(Input.Keys.U)) {
            for (IObservers o : observers) {
                o.actionHandle(ActionEnum.UPGRADE);
            }
        }
    }

    public void buildTurret() {
        if (Gdx.input.isKeyPressed(Input.Keys.B)) {
            for (IObservers o : observers) {
                o.actionHandle(ActionEnum.BUILD);
            }
        }
    }
    public void sellTurret() {
        if (Gdx.input.isKeyPressed(Input.Keys.B)) {
            for (IObservers o : observers) {
                o.actionHandle(ActionEnum.SELL);
            }
        }
    }


}