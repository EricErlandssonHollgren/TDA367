package Model.Enemy;
import Model.Entity;
import Model.PointHandler;



/**
 * All methods and parameters that an Enemy might need.
 */


public abstract class Enemy extends Entity {

    private final int worth;
    /**
     * @param worth  = is what the enemy is "worth". Points will be transferred to the player when the enemy has been killed
     */
    public Enemy(float positionX, float positionY, int worth) {
        super(positionX, positionY, 100, 100);
        this.worth = worth;
    }

    public float getX() {
        return positionX;
    }

    public float getY() {
        return positionY;
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
        //EntityHolder.getInstance().removeEntity(enemy);
        //TODO: Is currently writing and reading from the list so we might have to change the structure a bit.
        PointHandler.addPoints(amount);
    }

}
