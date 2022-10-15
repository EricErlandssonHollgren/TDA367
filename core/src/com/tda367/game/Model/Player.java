package Model;
import Interfaces.IObservers;
import Interfaces.IEntitySubscriber;

import java.util.ArrayList;
import java.util.List;


public class Player extends Entity implements IObservers {

    /**
     * The PlayerPositionSubscriber is an ArrayList which contains subscribers
     */
    List<IEntitySubscriber> subscriberList = new ArrayList<>();
    private static int damage = 25;
    private static final float velocity = 7;
    private boolean isAttacking;
    private boolean isAbleToMoveRight;
    private boolean isAbleToMoveLeft;
    private long latestAttackTime;
    public AttackHitbox attackHitbox;

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
        isAttacking  = true;
        attackHitbox = new AttackHitbox(positionX+width,positionY);
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
            attackHitbox.setX(positionX);
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
            attackHitbox.setX(positionX);
            for (IEntitySubscriber subscriber : subscriberList) {
                subscriber.updatePosition(positionX,positionY);
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

    /**
     * The method decrement player's health depending on the input of damage.
     * @param damage is the input for dealing damage
     */
    public void takeDamage(int damage){
        health -= damage;
        if(health <= 0){
            playerDead();
        }
    }
    private void playerDead(){
       /* for (IEntitySubscriber subscriber : subscriberList) {
            subscriber.updateState();
        }

        */
    }


    public void playerAttack(Entity enemy){
        long currentAttackTime = System.currentTimeMillis();
        long minIntervalbetweenAttack = 1000;
        if(isAttacking) {
            if (currentAttackTime > latestAttackTime + minIntervalbetweenAttack) {
                enemy.takeDamage(damage);
                System.out.println("Damage :)");
                latestAttackTime = currentAttackTime;
            }
        }

    }

    /**
     * The method allows the player to move left or right depending on the key that is pressed.
     * @param action uses the moveLeft() or moveRight() method
     */
    @Override
    public void actionHandle(ActionEnum action) {
        if(action == ActionEnum.LEFT){
            moveLeft();
            isAttacking = false;
        }
        if(action == ActionEnum.RIGHT) {
            moveRight();
            isAttacking = false;
        }

        if(action == ActionEnum.DAMAGE) {
            isAttacking = true;
        } else if (action == ActionEnum.DYING) {
            playerDead();
            isAttacking = false;
        }

    }

}
