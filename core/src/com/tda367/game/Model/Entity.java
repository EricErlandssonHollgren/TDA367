package Model;

import Interfaces.IObject;

public abstract class Entity {
    public float positionX;
    public float positionY;
    public HealthBar healthBar;
    public ActionEnum state;
    public int health = 100;
    protected int damage;
    public float width, height;


    public Entity(float positionX, float positionY, float entityWidth, float entityHeight) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.state = ActionEnum.IDLE;
        this.width = entityWidth;
        this.height = entityHeight;
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
