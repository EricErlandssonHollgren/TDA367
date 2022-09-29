package Model;
import Interfaces.IEntity;
import Interfaces.IObservers;
import Interfaces.IPlayerSubscriber;
import java.util.ArrayList;
import java.util.List;

public class Player implements IObservers, IEntity {
    /**
     * The PlayerPositionSubscriber is an ArrayList which contains subscribers
     */
    List<IPlayerSubscriber> subscriberList = new ArrayList<>();
    private float x;
    private float y;
    private int width;
    private int height;

    private float velocity = 15;


    public Player(float x, float y){
         this.x = x;
         this.y = y;
    }


    /**
     * A subscriber to handle the playerPosition. It should be updating its position
     * @param subscriber for the subscriberList
     */
    public void positionSubscriber(IPlayerSubscriber subscriber){
        subscriberList.add(subscriber);
        subscriber.updatePosition(x,y);
    }


    /**
     * The moveLeft() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveLeft(){
        x -= velocity;
        for (IPlayerSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(x,y);
        }
    }


    /**
     * The moveRight() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveRight(){
        x += velocity;
        for (IPlayerSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(x,y);
        }
    }

    /**
     * Gets the y-coordinate of the object of float
     *
     * @return y-coordinate of the object
     */
    public float getY(){
        return y;
    }

    /**
     * Gets the x-coordinate of the object of float
     * @return x-coordinate of the object
     */
    public float getX(){
        return x;
    }

    public float getVelocity() {
        return velocity;
    }

    public float stopVelocity(){
        return velocity = 0;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

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
