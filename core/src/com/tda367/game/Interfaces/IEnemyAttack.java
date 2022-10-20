package Interfaces;

import Model.Entity;
import Model.Tower;

public interface IEnemyAttack {

    /**
     * Getter for returning the x-position of the attack
     * @return the x-position for the attack
     */
    float getX();

    /**
     * Getter for returning the y-position of the attack
     * @return the y-position for the attack
     */
    float getY();

    /**
     * Getter for returning the width of the attack image
     * @return image width
     */
    float getWidth();

    /**
     * Getter for returning the height of the attack image
     * @return image height
     */
    float getHeight();

    /**
     * Getter for returning the attack damage
     */
    int getDamage();

    /**
     * Method for moving the attack along the x-axis
     * @param velocity the change in position for the attack
     */
    void move(double velocity);

    /**
     * Method for attacking a player
     * @param player the player that will take damage from the attack
     */
    void attackAtPlayer(Entity player);

    /**
     * Method for attacking a tower
     * @param tower the tower that will take damage from the attack
     */
    void attackAtTower(Tower tower);
}
