package Controller;

public class TimerListener {

    List <IObservers> observers = new ArrayList<>();

    public void addSubScribers(IObservers observer){
        observers.add(observer);
    }



    public void UpdateEnemyMovement(){
        for(IObservers o: observers){
            o.
        }
    }
}
