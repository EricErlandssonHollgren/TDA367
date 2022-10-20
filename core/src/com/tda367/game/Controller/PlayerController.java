package Controller;

import Interfaces.IObservers;
import Model.ActionEnum;
import com.badlogic.gdx.*;

import java.util.ArrayList;
import java.util.List;


public class PlayerController {
    private List<IObservers> observers = new ArrayList<>();

    /**
     * Add an observer to the observer list
     * @param observer observer that should be added
     */
    public void addObserver(IObservers observer){
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
        if (!(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) && !(Gdx.input.isKeyJustPressed(Input.Keys.D)) && !(Gdx.input.isKeyPressed(Input.Keys.LEFT)) && !(Gdx.input.isKeyPressed(Input.Keys.A))) {
            for (IObservers o: observers) {
                o.actionHandle(ActionEnum.IDLE);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            for (IObservers o : observers){
                o.actionHandle(ActionEnum.ATTACKING);
            }
        }
    }
}
