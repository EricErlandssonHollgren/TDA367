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

    public void UpdateEnemyMovement(){
        timer.GetInstance().GetTime();
        if(Math.ceil(timer) % 10 == 0){

        }

        //TODO: Depending on what the time is
        for(IObservers o: observers){
            o.actionHandle(ActionEnum.ENEMYMOVE);
        }
    }
}
