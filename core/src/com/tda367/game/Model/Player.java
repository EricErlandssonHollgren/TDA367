package Model;
import Interfaces.IObservers;
import Interfaces.IEntitySubscriber;
import com.badlogic.gdx.Input;

import java.util.ArrayList;
import java.util.List;


public class Player extends Entity implements IObservers {

    /**
     * The PlayerPositionSubscriber is an ArrayList which contains subscribers
     */
    List<IEntitySubscriber> subscriberList = new ArrayList<>();
    private int width;
    private int height;
    private int damage = 30;
    private float velocity = 7;

    private boolean isAbleToMoveRight;
    private boolean isAbleToMoveLeft;

    /**
     * When creating a player it should have two variables which defines its position.
     *  @param positionX represents the player's position on the x-axis
     *  @param positionY represents the player's position on the y-axis
     *  @param entityWidth represents the player's
     *  @param entityHeight represents the player's position on the y-axis
     */

    public Player(float positionX, float positionY, float entityWidth, float entityHeight){
        super(positionX, positionY, entityWidth, entityHeight);
        isAbleToMoveLeft = true;
        isAbleToMoveRight = true;
         this.positionX = positionX;
         this.positionY = positionY;
    }


    /**
     * A subscriber to handle the playerPosition. It should be updating its position
     * @param subscriber for the subscriberList
     */
    public void positionSubscriber(IEntitySubscriber subscriber){
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
            for (IEntitySubscriber subscriber : subscriberList) {
                subscriber.updatePosition(positionX, positionY);
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
            for (IEntitySubscriber playerPositionSubscriber : subscriberList) {
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
     * Gets the y-coordinate of the object of float
     * @return y-coordinate of the object
     */
    public float getY(){
        return positionY;
    }

    /**
     * Gets the x-coordinate of the object of float
     * @return x-coordinate of the object
     */
    public float getX(){
            return positionX;
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

    public int getDamage(){
        return damage;
    }

    /**
     * The method allows the player to move left or right depending on the key that is pressed.
     * @param key uses the moveLeft() or moveRight() method
     */
    @Override
    public void actionHandle(ActionEnum key) {
        if(key == ActionEnum.LEFT){
            moveLeft();
            state = STATE.RUNNINGLEFT;
        }
        if(key == ActionEnum.RIGHT){
            moveRight();
            state = STATE.RUNNINGRIGHT;
        }
        if (key == ActionEnum.NOTPRESSED) {
            state = STATE.IDLE;
        }
    }
}
