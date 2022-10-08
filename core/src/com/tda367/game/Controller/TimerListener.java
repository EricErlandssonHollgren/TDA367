package Controller;
import java.util.ArrayList;
import java.util.List;
import Interfaces.IObservers;
import Model.GameTimer;
public class TimerListener {

    List <IObservers> observers = new ArrayList<>();

    private GameTimer timer;
    public void addSubScribers(IObservers observer){
        observers.add(observer);
    }

}
