package Model;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public abstract class Entity{

    protected float positionX;
    protected float positionY;
    public HealthBar healthBar;
    protected Texture entityImg;
    protected STATE state;
    protected int health = 100;

    public Entity(float positionX, float positionY, float entityWidth, float entityHeight) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.state = STATE.IDLE;
        this.healthBar = new HealthBar(positionX,positionY, 100f, entityWidth, entityHeight);
    }

    public void updateHealthBar() {
        healthBar.updatePosition(positionX,positionY);
    }

    public STATE getState() {
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
        return positionX;
    }

    /**
     * Gets the x-coordinate of the object of float
     * @return x-coordinate of the object
     */
    public float getPosX(){
        return positionY;
    }

}