package Model;

import Interfaces.IObject;

public abstract class Entity {
    protected float positionX;
    protected float positionY;
    public HealthBar healthBar;
    public ActionEnum state;
    protected int health;
    protected int damage;
    protected float width, height;
    protected boolean isDead;


    public Entity(float positionX, float positionY, float entityWidth, float entityHeight, int health) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.height = entityHeight;
        this.width = entityWidth;
        this.health = health;
        this.isDead = false;
        this.healthBar = new HealthBar(positionX,positionY, 100f, entityWidth, entityHeight);
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


    public void updateHealthBar() {
        healthBar.updatePosition(positionX,positionY);
    }

    public ActionEnum getState() {
        return state;
    }

    public int getHealth() {
        return health;
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

    public void takeDamage(int damage){
        health -= damage;
    }

}
