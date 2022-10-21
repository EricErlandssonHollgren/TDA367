package Model;

import Interfaces.IGameOverSubscriber;

import java.util.ArrayList;
import java.util.List;

public class GameOverInstantiator {

    private static GameOverInstantiator instance;
    private List<IGameOverSubscriber> gameOverSubscriberList;

    private GameOverInstantiator() {
        gameOverSubscriberList = new ArrayList<IGameOverSubscriber>();
    }

    public static GameOverInstantiator GetInstance(){
        if(instance == null){
            instance = new GameOverInstantiator();
        }
        return instance;
    }

    /**
     * Add subscriber to the gameOverSubscriberList list
     * @param subscriber object that should be added
     */
    public void addSubscribers(IGameOverSubscriber subscriber) {
        gameOverSubscriberList.add(subscriber);
    }

    /**
     *  Notify all subscribers to update.
     */
    public void updateGameOverSubscribers() {
        for (IGameOverSubscriber subscriber : gameOverSubscriberList) {
            subscriber.updateScreen();
        }
    }
}
