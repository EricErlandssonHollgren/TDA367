package Model;
import Interfaces.IObservers;
import Interfaces.IPlayerSubscriber;
import Interfaces.IRectangle;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player implements IObservers {
    /**
     * The PlayerPositionSubscriber is an ArrayList which contains subscribers
     */
    List<IPlayerSubscriber> subscriberList = new ArrayList<>();
    private Vector2 position;
    private int width;
    private int height;
    private int size = 1;

    private Rectangle bounds = new Rectangle();

    /**
     * The player constructor takes an position of a Vector2 as parameter.
     * It defines the player's height, width and position.
     * @param position represents the player's position
     */
    public Player(Vector2 position){
         this.position = position;
         this.bounds.height = size;
         this.bounds.width = size;
    }


    /**
     * A subscriber to handle the playerPosition. It should be updating its position
     * @param subscriber for the subscriberList
     */
    public void positionSubscriber(IPlayerSubscriber subscriber){
        subscriberList.add(subscriber);
        subscriber.updatePosition(position);
    }


    /**
     * The moveLeft() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveLeft(){
        position.x -= 15;
        for (IPlayerSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(position);
        }
    }


    /**
     * The moveRight() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveRight(){
        position.x += 15;
        for (IPlayerSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(position);
        }
    }

    /**
     * Gets the y-coordinate of the object of float
     * @return y-coordinate of the object
     */
    public float getPosY(){
        return position.y;
    }

    /**
     * Gets the x-coordinate of the object of float
     * @return x-coordinate of the object
     */
    public float getPosX(){
        return position.x;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }


    @Override
    public void keyPressed(float key) {
        if(key == Input.Keys.LEFT){
            moveLeft();
        }
        if(key == Input.Keys.RIGHT){
            moveRight();
        }
    }

}
