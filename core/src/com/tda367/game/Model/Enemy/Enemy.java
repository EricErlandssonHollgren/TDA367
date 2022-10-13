package Model.Enemy;
import Interfaces.IEnemyAttack;
import Interfaces.IObject;
import Model.Entity;
import Model.EntityHolder;
import Model.PointHandler;



/**
 * All methods and parameters that an Enemy might need.
 */


public abstract class Enemy extends Entity {

    private final int worth;
    private final IObject enemyAttack;
    /**
     * @param worth  = is what the enemy is "worth". Points will be transferred to the player when the enemy has been killed
     */
    public Enemy(float positionX, float positionY, int worth, IObject enemyAttack) {
        super(positionX, positionY, 100, 100);
        this.worth = worth;
        this.enemyAttack = enemyAttack;
    }

    /**
     * moves the enemy in x-direction only with a change of 0.2px.
     */
    public void moveEnemy() {
        double speed = 0.2;
        positionX -= speed;
    }

    public float getUpdatedPosition() {
        moveEnemy();
        return positionX;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if(health <= 0){
            enemyDead(this, worth);
            System.out.println("I am dead");
        }
    }

    private void enemyDead(Entity enemy, int amount){
        EntityHolder.getInstance().removeEntity(enemy);
        PointHandler.addPoints(amount);
    }

}
