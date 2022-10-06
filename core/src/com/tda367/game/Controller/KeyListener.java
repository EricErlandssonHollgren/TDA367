package Controller;

import Interfaces.IObservers;
import Model.MovementDirection;
import com.badlogic.gdx.*;
import Model.Player;

import java.util.ArrayList;
import java.util.List;


public class KeyListener{
    List<IObservers> observers = new ArrayList<>();

    public void addSubscribers(IObservers observer){
        observers.add(observer);
    }
/*
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
    */

    /**
     * UpdatePlayerPosition listens to inputs depending on which key is pressed.
     * When being listened it tells the player to either use moveLeft()-
     * or moveRight()-method.
     */
    public void UpdatePlayerMovement(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            for (IObservers o: observers) {
                o.keyPressed(MovementDirection.LEFT);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            for (IObservers o: observers) {
                o.keyPressed(MovementDirection.RIGHT);
            }
        }
    }


}
