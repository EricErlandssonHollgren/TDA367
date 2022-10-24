package Model;
import Interfaces.*;
import Model.*;


/**
 * All methods and parameters that an Enemy might need.
 */


public class Enemy extends Entity implements IPaus{

    private int worth;
    public final IEnemyAttack enemyAttack;
    private int damage;
    private boolean isGamePaused = false;
    private double velocity;
    private MainHandler goldHandler;
    private MainHandler pointsHandler;

    /**
     * Constructor for creating an enemy with its related values.
     * @param positionX the set position for enemy along the x-axis.
     * @param positionY the set position for enemy along the y-axis.
     * @param worth what the enemy is worth. when killed by player this value will be turned into points.
     * @param enemyAttack the type of attack that the enemy can do.
     * @param health the number of health points the enemy has, when zero the enemy dies.
     */
    public Enemy(float positionX, float positionY, int worth, IEnemyAttack enemyAttack, int health) {
        super(positionX, positionY, 70, 70, health);
        this.worth = worth;
        this.enemyAttack = enemyAttack;
        this.damage = 20;
        this.velocity = 0.3;
        goldHandler = new Goldhandler();
        pointsHandler = new PointHandler();
        goldHandler.setSuccessor(pointsHandler);
    }

    /**
     * A getter for returning the specific attack of an enemy
     * @return the enemy attack
     */
    public IEnemyAttack getEnemyAttack() {
        return enemyAttack;
    }

    /**
     * moves the enemy in x-direction with a change of value that is set in the constructor.
     */
    public void moveEnemy() {
        if (!isGamePaused) {
            enemyAttack.move(velocity);
            positionX -= velocity;
        }
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
    @Override
    public void takeDamage(int damage) {
        if (!isGamePaused) {
            health -= damage;
            if (health <= 0) {
                enemyDead();
                isDead = true;
            }
        }
    }

    /**
     * When enemy's health is zero the entity holder should remove it from the list
     * , points is added based on the enemy's worth and so is gold.
     */
    private void enemyDead(){
        EntityHolder.getInstance().removeEntity(this);
        EntityHolder.getInstance().removeFireAttack(enemyAttack);
        goldHandler.handleRequest(new Request(HandlerItemDefiners.GOLD, worth));
        goldHandler.handleRequest(new Request(HandlerItemDefiners.POINTS, worth));

    }

    @Override
    public void IsGamePaused(boolean isGamePaused) {
        this.isGamePaused = isGamePaused;
    }
}
