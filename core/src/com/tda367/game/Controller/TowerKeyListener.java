package Controller;

import Interfaces.IObservers;
import Model.ActionEnum;
import com.badlogic.gdx.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TowerKeyListener {
    List<IObservers> observers;
    List<Button> towerButtons;
    Button upgrade;
    public TowerKeyListener(){
        observers = new ArrayList<>();
        towerButtons = new ArrayList<>();
        upgrade = new Button();
    }

    public void addSubscribers(IObservers observer){
        observers.add(observer);
    }

    public void upgradeTower() {
            for (IObservers o : observers) {
                o.actionHandle(ActionEnum.UPGRADE);
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