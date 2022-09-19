package Model;

import Controller.KeyListener;
import Interfaces.PlayerPositionSubscriber;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class Player {
    /**
     * The PlayerPositionSubscriber is an ArrayList which contains subscribers
     */
    List<PlayerPositionSubscriber> subscriberList = new ArrayList<>();
    private KeyListener keyListener = new KeyListener(this);
    private float x;
    private float y;

    /**
     * When creating a player it should have two variables which defines its position.
     * @param x represents the player's position on the x-axis
     * @param y represents the player's position on the y-axis
     */
    public Player(float x, float y){
        this.x = x;
        this.y = y;
    }

    /**
     * A subscriber to handle the playerPosition. It should be updating its position
     */
    public void positionSubscriber(PlayerPositionSubscriber subscriber){
        subscriberList.add(subscriber);
        subscriber.updatePosition(x, y);
    }
    /**
     * The moveLeft() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveLeft(){
        x -= 15f;
        for (PlayerPositionSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(x,y);
        }
    }


    /**
     * The moveRight() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveRight(){
        x += 15f;
        for (PlayerPositionSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(x,y);
        }
    }

    /**
     * Gets the y-coordinate of the object of float
     * @return y-coordinate of the object
     */
    public float getPosY(){
        return y;
    }

    /**
     * Gets the x-coordinate of the object of float
     * @return x-coordinate of the object
     */
    public float getPosX(){
        return x;
    }
}
