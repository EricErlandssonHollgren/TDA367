package Controller;

import Interfaces.IObservers;
import Interfaces.IPaus;
import View.PausView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.ArrayList;
import java.util.List;

public class PausController {

    private List<IPaus> observers = new ArrayList<>();
    private int timesPressed;

    /**
     * Takes the argument and adds it to the observerlist.
     * @param observer
     */
    public void addSubscribers(IPaus observer){
        observers.add(observer);
    }

    public void updatePausMenu() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            timesPressed++;
            if (timesPressed % 2 == 1) {
                for (IPaus observer : observers) {
                    observer.IsGamePaused(true);
                }
            }
            if (timesPressed % 2 == 0) {
                for (IPaus observer : observers) {
                    observer.IsGamePaused(false);
                }
            }
        }
    }
}
