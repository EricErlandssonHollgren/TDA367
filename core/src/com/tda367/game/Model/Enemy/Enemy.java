package Model.Enemy;
import Model.Entity;


/**
 * All methods and parameters that an Enemy might need.
 */


public abstract class Enemy extends Entity {

    private final int worth;

    /**
     * @param worth  = is what the enemy is "worth". int will be transferred to the player when the enemy has been killed
     */
    public Enemy(float positionX, float positionY, int entityWidth, int entityHeight, int worth) {
        super(positionX, positionY, entityWidth, entityHeight);
        this.worth = worth;
    }

    public int getWorth() {
        return worth;
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
        //TODO: Uppdatera i healthbaren.
    }


}
