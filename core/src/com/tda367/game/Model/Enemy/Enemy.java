package Model.Enemy;

import Model.Entity;
import Model.Waves;

/**
 * All methods and parameters that an Enemy might need.
 */


public abstract class Enemy extends Entity {

    private final int worth;
    private int HP;
    private Waves wave;
    private final int damage;

    /**
     * @param worth  = is what the enemy is "worth". int will be transferred to the player when the enemy has been killed
     * @param HP     = every enemy has a number of "health points" that will decrease as it is being attacked.
     * @param damage = is how much damage the enemy will do to the player when it attacks.
     */
    public Enemy(float positionX, float positionY, int entityWidth, int entityHeight, int worth, int HP, int damage) {
        super(positionX, positionY, entityWidth, entityHeight);
        this.worth = worth;
        this.HP = HP;
        this.wave = new Waves();
        this.damage = damage;
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

    /**
     * moves the enemy in x-direction only with a change of 0.2px.
     */
    public void moveEnemy() {
        double speed = 0.2;
        positionX -= speed;
    }

    public int getDamage() {
        return damage;
    }
}
