package Model;

import com.badlogic.gdx.graphics.Texture;

public abstract class Entity {

    protected float positionX;
    protected float positionY;
    protected HealthBar healthBar;
    protected Texture entityImg;
    protected STATE State;

    public Entity(float positionX, float positionY, int health) {
        this.positionX = positionX;
        this.positionY = positionY;

        setEntityImg();
        healthBar = new HealthBar(this.positionX, this.positionY, health, entityImg.getHeight(), entityImg.getWidth());
    }

    public void updateHealthBar() {
        healthBar.updatePosition(positionX,positionY);
    }

    abstract void setEntityImg();

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
