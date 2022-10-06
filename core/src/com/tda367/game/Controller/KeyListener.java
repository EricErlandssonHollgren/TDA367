package Controller;

import Interfaces.IObservers;
import com.badlogic.gdx.*;
import Model.Player;

import java.util.ArrayList;
import java.util.List;


public class KeyListener{
    List<IObservers> observers = new ArrayList<>();

    public void addSubscribers(IObservers observer){
        observers.add(observer);
    }
    /**
     * UpdatePlayerPosition listens to inputs depending on which key is pressed.
     * When being listened it tells the player to either use moveLeft()-
     * or moveRight()-method.
     */
    public void UpdatePlayerPosition(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            for (IObservers o: observers) {
                o.keyPressed(Input.Keys.LEFT);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            for (IObservers o: observers) {
                o.keyPressed(Input.Keys.RIGHT);
            }
        }
    }
}
