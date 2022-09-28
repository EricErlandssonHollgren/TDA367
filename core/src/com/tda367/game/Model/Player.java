package Model;

import Interfaces.IObservers;
import Interfaces.PlayerPositionSubscriber;
import com.badlogic.gdx.Input;

import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.graphics.Texture;


public class Player extends Entity implements IObservers {
    /**
     * The PlayerPositionSubscriber is an ArrayList which contains subscribers
     */
    List<PlayerPositionSubscriber> subscriberList = new ArrayList<>();

    /**
     * When creating a player it should have two variables which defines its position.
     *  @param positionX represents the player's position on the x-axis
     *  @param positionY represents the player's position on the y-axis
     */
    public Player(float positionX, float positionY, int health ){
        super(positionX, positionY, health);
    }


    /**
     * A subscriber to handle the playerPosition. It should be updating its position
     * @param subscriber for the subscriberList
     */
    public void positionSubscriber(PlayerPositionSubscriber subscriber){
        subscriberList.add(subscriber);
        subscriber.updatePosition(positionX, positionY);
    }
    /**
     * The moveLeft() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveLeft(){
        positionX -= 15f;
        for (PlayerPositionSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(positionX,positionY);
            updateHealthBar();
        }
    }

    /**
     * The moveRight() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveRight(){
        positionX += 15f;
        for (PlayerPositionSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(positionX,positionY);
            updateHealthBar();
        }
    }

    public void crouche() {

    }

    protected void setEntityImg(){
        entityImg = new Texture("adventurer-idle-01.png");
    }

    @Override
    public void keyPressed(int key) {
        if(key == Input.Keys.LEFT){
            moveLeft();
        }
        if(key == Input.Keys.RIGHT){
            moveRight();
        }
    }
}
