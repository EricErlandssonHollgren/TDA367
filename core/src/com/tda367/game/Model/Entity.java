package Model;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public abstract class Entity{

    protected float positionX;
    protected float positionY;
    public HealthBar healthBar;
    protected Texture entityImg;
    protected STATE state;

    public Entity(float positionX, float positionY, int health) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.state = STATE.IDLE;
        healthBar = new HealthBar(this.positionX, this.positionY, health);
    }

    public void updateHealthBar() {
        healthBar.updatePosition(positionX,positionY);
    }
    /**
     * Gets the y-coordinate of the object of float
     * @return y-coordinate of the object
     */
    public float getPosY(){
        return positionX;
    }

    public STATE getState() {
        return state;
    }




    /**
     * Gets the x-coordinate of the object of float
     * @return x-coordinate of the object
     */
    public float getPosX(){
        return positionY;
    }

}
