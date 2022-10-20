package Controller;

import Interfaces.IObservers;
import Interfaces.IReSpawnable;

import java.util.ArrayList;
import java.util.List;

public class PlayerSpawnController {
    private List<IReSpawnable> observers;

    //A constructor for the controller that holds a list of observers that calls them to handle different actions.
    public PlayerSpawnController(){
        observers = new ArrayList<>();
    }

    //Adds an observer to this controller.
    public void addSubscribers(IReSpawnable observer){
        observers.add(observer);
    }

    public void respawn() {
        for (IReSpawnable observer : observers) {
            observer.respawn(5f);
        }
    }

}