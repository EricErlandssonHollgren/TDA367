package Model;

import Interfaces.IObject;

public abstract class Entity {

    /**
     * positionX is of type float
     */
    protected float positionX;
    /**
     * positionY is of type float
     */
    protected float positionY;
    /**
     * A healthbar is of a class HealthBar
     */
    public HealthBar healthBar;
    /**
     * An state is of an ActionEnum
     */
    public ActionEnum state;
    /**
     * health is of type int
     */
    protected int health;
    /**
     * damage is of type int
     */
    protected int damage;
    /**
     * width and height is of type float
     */
    protected float width, height;
    /**
     * isDead is a boolean
     */
    protected boolean isDead;

    /**
     * When creating an entity it should have 5 parameters
     * @param positionX determines its position of x
     * @param positionY determines its position of y
     * @param entityWidth determines its width
     * @param entityHeight determines its height
     * @param health determines its health
     */
    public Entity(float positionX, float positionY, float entityWidth, float entityHeight, int health) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.height = entityHeight;
        this.width = entityWidth;
        this.health = health;
        this.isDead = false;
        this.healthBar = new HealthBar(positionX,positionY, health, entityWidth, entityHeight);
    }

    /**
     * Getter for width
     * @return float for width
     */
    public float getWidth(){
        return width;
    }

    /**
     * Getter for height
     * @return float for height
     */
    public float getHeight(){
        return height;
    }


    /**
     * Updates an entity's healthbar depending on its position
     */
    public void updateHealthBar() {
        healthBar.updateHealth(health);
        healthBar.updatePosition(positionX,positionY);
    }

    /**
     * Will get the state for an entity
     * @return its state
     */

    public ActionEnum getState() {
        return state;
    }

    /**
     * Will get the health of an entity
     * @return health
     */
    public int getHealth() {
        return health;
    }

    public HealthBar getHealthBar() {
        return healthBar;
    }

    /**
     * Gets the y-coordinate of the object of float
     * @return y-coordinate of the object
     */

    public float getPosY(){
        return positionY;
    }

    /**
     * Gets the x-coordinate of the object of float
     * @return x-coordinate of the object
     */
    public float getPosX(){
        return positionX;
    }

    /**
     * The entity is able to receive damage and the health will decrement for each time
     * @param damage is of type int
     */

    public void takeDamage(int damage){
        health -= damage;
    }

}
