package Controller;

import Interfaces.IObservers;
import Model.ActionEnum;
import com.badlogic.gdx.*;

import java.util.ArrayList;
import java.util.List;


public class PlayerKeyListener {
    List<IObservers> observers = new ArrayList<>();

    public void addSubscribers(IObservers observer){
        observers.add(observer);
    }
    

    /**
     * UpdatePlayerPosition listens to inputs depending on which key is pressed.
     * When being listened it tells the player to either use moveLeft()-
     * or moveRight()-method.
     */
    public void UpdatePlayerMovement(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            for (IObservers o: observers) {
                o.actionHandle(ActionEnum.LEFT);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            for (IObservers o: observers) {
                o.actionHandle(ActionEnum.RIGHT);
            }
        }
    }
}
