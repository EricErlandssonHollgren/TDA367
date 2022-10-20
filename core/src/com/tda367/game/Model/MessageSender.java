package Model;

import Interfaces.IMessageSubscriber;

import java.util.ArrayList;
import java.util.List;

public class MessageSender {
    private List<IMessageSubscriber> messageSubscriberList;
    private static MessageSender instance;

    /**
     * Constructs the class and creates an empty messageSubscriberList.
     */
    private MessageSender() {
        messageSubscriberList = new ArrayList<IMessageSubscriber>();
    }

    /**
     * Creates instance of game timer
     * @return instance
     */
    public static MessageSender GetInstance(){
        if(instance == null){
            instance = new MessageSender();
        }
        return instance;
    }

    /**
     * Add subscriber to the IMessageSubscriber list
     * @param subscriber object that should be added
     */
    public void addSubscribers(IMessageSubscriber subscriber){
        messageSubscriberList.add(subscriber);
    }

    /**
     * Notify all subscribers to update the message
     * @param message
     */
    public void sendMessage(String message) {
        for (IMessageSubscriber subscriber : messageSubscriberList) {
            subscriber.UpdateMessage(message);
        }
    }
}
