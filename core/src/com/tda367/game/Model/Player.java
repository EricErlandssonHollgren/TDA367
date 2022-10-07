package Model;
import Interfaces.IEntity;
import Interfaces.IObservers;
import Interfaces.IPlayerSubscriber;
import com.badlogic.gdx.Input;

import Interfaces.IPlayerSubscriber;
import java.util.ArrayList;
import java.util.List;


public class Player extends Entity implements IObservers, IEntity {

    /**
     * The PlayerPositionSubscriber is an ArrayList which contains subscribers
     */
    List<IPlayerSubscriber> subscriberList = new ArrayList<>();
    private int width;
    private int height;
    private float velocity = 7;


    private boolean isAbleToMoveRight;
    private boolean isAbleToMoveLeft;

    /**
     * When creating a player it should have two variables which defines its position.
     *  @param positionX represents the player's position on the x-axis
     *  @param positionY represents the player's position on the y-axis
     *  @param entityWidth represents the player's
     *  @param entityHieght represents the player's position on the y-axis
     */

    public Player(float positionX, float positionY, float entityWidth, float entityHieght){
        super(positionX, positionY, entityWidth, entityHieght);
        isAbleToMoveLeft = true;
        isAbleToMoveRight = true;
         this.positionX = positionX;
         this.positionY = positionY;
         this.width = 50;
         this.height = 37;

    }


    /**
     * A subscriber to handle the playerPosition. It should be updating its position
     * @param subscriber for the subscriberList
     */
    public void positionSubscriber(IPlayerSubscriber subscriber){
        subscriberList.add(subscriber);
        subscriber.updatePosition(positionX,positionY);
        updateHealthBar();
    }


    /**
     * The moveLeft() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveLeft(){
        if(isAbleToMoveLeft) {
            positionX -= velocity;
            for (IPlayerSubscriber playerPositionSubscriber : subscriberList) {
                playerPositionSubscriber.updatePosition(positionX, positionY);
                updateHealthBar();
            }
        }
    }


    /**
     * The moveRight() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveRight(){
        if(isAbleToMoveRight){
            positionX += velocity;
            for (IPlayerSubscriber playerPositionSubscriber : subscriberList) {
                playerPositionSubscriber.updatePosition(positionX,positionY);
                updateHealthBar();
            }
        }
    }

    /**
     * The setter enables the player to move right
     * @param ableToMoveRight is a boolean to allow the player move right.
     */
    public void setAbleToMoveRight(boolean ableToMoveRight) {
        isAbleToMoveRight = ableToMoveRight;
    }


    /**
     * The setter enbles the player to move left.
     * @param ableToMoveLeft is a boolean to allow the player move left.
     */
    public void setAbleToMoveLeft(boolean ableToMoveLeft) {
        isAbleToMoveLeft = ableToMoveLeft;
    }


    public STATE getState() {
        return state;
    }

    /**
     * Gets the x-coordinate of the object of float
     * @return x-coordinate of the object
     */
    public float getX(){
        return positionX;
    }

    /**
     * Gets the y-coordinate of the object of float
     * @return y-coordinate of the object
     */
    public float getY(){
        return positionY;
    }

    /**
     * Gets the velocity of the player
     * @return the velocity of the player
     */

    public float getVelocity() {
        return velocity;
    }

    /**
     * Gets the height of the object of int
     * @return the height of a player
     */
    public int getHeight(){
        return height;
    }

    /**
     * Gets the width of the object of int
     * @return the width of a player
     */

    public int getWidth(){
        return width;
    }

    /**
     * The method allows the player to move left or right depending on the key that is pressed.
     * @param key uses the moveLeft() or moveRight() method
     */
    @Override
    public void keyPressed(MovementDirection key) {
        if(key == MovementDirection.LEFT){
            moveLeft();
        }
        if(key == MovementDirection.RIGHT){
            moveRight();
        }
    }
}
