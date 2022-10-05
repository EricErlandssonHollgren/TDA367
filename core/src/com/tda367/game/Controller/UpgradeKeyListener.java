package Controller;

import Interfaces.IObservers;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.ArrayList;
import java.util.List;

public class UpgradeKeyListener {
    List<IObservers> observers = new ArrayList<>();

    public void addSubscribers(IObservers observer){
        observers.add(observer);
    }

    public void upgradeTower() {
        if (Gdx.input.isKeyPressed(Input.Keys.U)) {
            for (IObservers o : observers) {
                o.keyPressed(Input.Keys.U);
            }
        }
    }

    public void buildTurret() {
        if (Gdx.input.isKeyPressed(Input.Keys.B)) {
            for (IObservers o : observers) {
                o.keyPressed(Input.Keys.B);
            }
        }
    }
}
