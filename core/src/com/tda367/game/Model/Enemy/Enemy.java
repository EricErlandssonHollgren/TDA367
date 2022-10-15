package Model.Enemy;
import Interfaces.*;
import Model.Entity;
import Model.EntityHolder;
import Model.Goldhandler;
import Model.PointHandler;

import java.util.List;


/**
 * All methods and parameters that an Enemy might need.
 */


public abstract class Enemy extends Entity{
    private final int worth;
    public final IEnemyAttack enemyAttack;
    private EntityHolder entityHolder;
    private boolean isDead;
    /**
     * @param worth  = is what the enemy is "worth". Points will be transferred to the player when the enemy has been killed
     */
    public Enemy(float positionX, float positionY, int worth, IEnemyAttack enemyAttack) {
        super(positionX, positionY, 70, 70);
        this.worth = worth;
        this.enemyAttack = enemyAttack;
        this.isDead = false;
    }

    /**
     * moves the enemy in x-direction only with a change of 0.2px.
     */
    public void moveEnemy() {
        double speed = 0.5;
        positionX -= speed;
    }


    public void takeDamage(int damage) {
        health -= damage;
        if(health <= 0){
            enemyDead(this, worth);
            isDead = true;
        }
    }

    private void enemyDead(Entity enemy, int amount){
        EntityHolder.getInstance().removeEntity(enemy);
        PointHandler.addPoints(amount);
        Goldhandler.addGold(amount);
    }



}
