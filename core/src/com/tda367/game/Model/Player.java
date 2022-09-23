package Model;
import Interfaces.IObservers;
import Interfaces.IPlayerSubscriber;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.BodyDef;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player implements IObservers {
    /**
     * The PlayerPositionSubscriber is an ArrayList which contains subscribers
     */
    List<IPlayerSubscriber> subscriberList = new ArrayList<>();
    private int width;
    private int height;
    private int health = 100;
    BodyDef bodyDef = new BodyDef();


    /**
     * When creating a player it should have two variables which defines its position.
     * @param x represents the player's position on the x-axis
     * @param y represents the player's position on the y-axis
     */
    public Player(float x, float y, int height, int width){
         this.height = height;
         this.width = width;
         bodyDef.type = BodyDef.BodyType.DynamicBody;
         bodyDef.position.x = x;
         bodyDef.position.y = y;

    }


    /**
     * A subscriber to handle the playerPosition. It should be updating its position
     * @param subscriber for the subscriberList
     */
    public void positionSubscriber(IPlayerSubscriber subscriber){
        subscriberList.add(subscriber);
        subscriber.updatePosition(bodyDef.position.x, bodyDef.position.y);
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
        bodyDef.position.x -= 15f;
        for (IPlayerSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(bodyDef.position.x,bodyDef.position.y);
        }
    }


    /**
     * The moveRight() method is allowing the character to move to the right side,
     * for each subscriber in a subscriber list.
     */
    public void moveRight(){
        bodyDef.position.x += 15f;
        for (IPlayerSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(bodyDef.position.x,bodyDef.position.y);
        }
    }

    /**
     * Gets the y-coordinate of the object of float
     * @return y-coordinate of the object
     */
    public float getPosY(){
        return bodyDef.position.y;
    }

    /**
     * Gets the x-coordinate of the object of float
     * @return x-coordinate of the object
     */
    public float getPosX(){
        return bodyDef.position.x;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
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
