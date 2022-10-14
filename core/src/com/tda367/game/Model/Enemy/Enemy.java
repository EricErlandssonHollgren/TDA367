package Model.Enemy;
import Interfaces.IEntitySubscriber;
import Interfaces.IObject;
import Model.Entity;
import Model.EntityHolder;
import Model.Goldhandler;
import Model.PointHandler;

import java.util.ArrayList;
import java.util.List;


/**
 * All methods and parameters that an Enemy might need.
 */


public abstract class Enemy extends Entity {
    private final int worth;
    public final IProjectile enemyAttack;
    private List<IEntitySubscriber> subscriberList = new ArrayList<>();
    /**
     * @param worth  = is what the enemy is "worth". Points will be transferred to the player when the enemy has been killed
     */
    public Enemy(float positionX, float positionY, int worth, IProjectile enemyAttack) {
        super(positionX, positionY, 100, 100);
        this.worth = worth;
        this.enemyAttack = enemyAttack;
    }

    public void enemySubscriber(IEntitySubscriber subscriber){
        subscriberList.add(subscriber);
        subscriber.updatePosition(positionX,positionY);
    }

    /**
     * moves the enemy in x-direction only with a change of 0.2px.
     */
    public void moveEnemy() {
        double speed = 0.2;
        positionX -= speed;
    }


    public void takeDamage(int damage) {
        health -= damage;
        if(health <= 0){
            enemyDead(this, worth);
            System.out.println("I am dead");
        }
    }

    private void enemyDead(Entity enemy, int amount){
       /* for (IEntitySubscriber e: subscriberList) {
            e.updateState();
        }
        */
        EntityHolder.getInstance().removeEntity(enemy);
        PointHandler.addPoints(amount);
        Goldhandler.addGold(amount);
    }

}
