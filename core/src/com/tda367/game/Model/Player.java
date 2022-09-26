package Model;
import Interfaces.IObservers;
import Interfaces.IPlayerSubscriber;
import Interfaces.IRectangle;
import com.badlogic.gdx.Input;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player implements IObservers {
    /**
     * The PlayerPositionSubscriber is an ArrayList which contains subscribers
     */
    List<IPlayerSubscriber> subscriberList = new ArrayList<>();
    private int x;
    private int y;
    private int width;
    private int height;
    private int size = 1;

    private Rectangle bounds = new Rectangle();

    /**
     * When creating a player it should have two variables which defines its position.
     * @param x represents the player's position on the x-axis
     * @param y represents the player's position on the y-axis
     */
    public Player(int x, int y){
         this.x = x;
         this.y = y;
         this.bounds.height = size;
         this.bounds.width = size;
    }


    /**
     * A subscriber to handle the playerPosition. It should be updating its position
     * @param subscriber for the subscriberList
     */
    public void positionSubscriber(IPlayerSubscriber subscriber){
        subscriberList.add(subscriber);
        subscriber.updatePosition(x, y);
    }

    public void playerAttack(){
        for (IPlayerSubscriber playerAttackSubscriber: subscriberList) {
            playerAttackSubscriber.updateMovement();
        }
    }

    /**
     * The moveLeft() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveLeft(){
        x -= 15;
        for (IPlayerSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(x,y);
        }
    }


    /**
     * The moveRight() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveRight(){
        x += 15;
        for (IPlayerSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(x,y);
        }
    }

    /**
     * Gets the y-coordinate of the object of float
     * @return y-coordinate of the object
     */
    public int getPosY(){
        return y;
    }

    /**
     * Gets the x-coordinate of the object of float
     * @return x-coordinate of the object
     */
    public int getPosX(){
        return x;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
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
