package Model;
import Interfaces.*;
import Model.*;


/**
 * All methods and parameters that an Enemy might need.
 */


public class Enemy extends Entity{

    private int worth;
    public final IEnemyAttack enemyAttack;
    private int damage;
    private boolean isAttacking;
    /**
     * @param worth  = is what the enemy is "worth". Points will be transferred to the player when the enemy has been killed
     */
    public Enemy(float positionX, float positionY, int worth, IEnemyAttack enemyAttack, int health) {
        super(positionX, positionY, 70, 70, health);
        this.worth = 20;
        this.enemyAttack = enemyAttack;
        this.isAttacking = true;
        this.damage = 20;
    }

    public IEnemyAttack getEnemyAttack() {
        return enemyAttack;
    }

    /**
     * moves the enemy in x-direction only with a change of 0.2px.
     */
    public void moveEnemy() {
        double speed = 0.5;
        enemyAttack.move();
        positionX -= speed;
    }
    /**
     * Enemy's getDamage method
     * @return damage to other objects
     */
    public int getDamage(){
        return damage;
    }

    /**
     * Enemy is able to take damage. For each time it is taking damage the health decrements.
     * If the health is less or equal to zero it should die.
     * @param damage represents the damage taken from either a player or cannonball.
     */

    public void takeDamage(int damage) {
        health -= damage;
        if(health <= 0){
            enemyDead();
            isDead = true;
        }
    }

    /**
     * When enemy's health is zero the entity holder should remove it from the list
     * , points is added based on the enemy's worth and so is gold.
     */
    private void enemyDead(){
        EntityHolder.getInstance().removeEntity(this);
        PointHandler.addPoints(worth);
        Goldhandler.addGold(worth);
    }

}
