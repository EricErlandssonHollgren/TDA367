package Model.Enemy;
import Interfaces.IEntity;
import Interfaces.IEntitySubscriber;

import java.util.ArrayList;
import java.util.List;
import Interfaces.IObservers;

/**
 * All methods and parameters that an Enemy might need.
 */


public class Enemy {
    private int worth;
    private int HP;
    private float positionX;
    private float positionY;
    private int damage = 10;
    List <IEntitySubscriber> subscribersList = new ArrayList<>();

    /**
     *
     * @param worth = is what the enemy is "worth". int will be transferred to the player when the enemy has been killed
     * @param HP = every enemy has a number of "health points" that will decrease as it is being attacked.

     */
    public Enemy(int worth, int HP, float positionX, float positionY) {
        this.worth = worth;
        this.HP = HP;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getWorth() {
        return worth;
    }

    public int getHP() {
        return HP;
    }
    public float getX() {
        return positionX;
    }
    public float getY() {
        return positionY;
    }
    public int getDamage(){return damage;}


}
