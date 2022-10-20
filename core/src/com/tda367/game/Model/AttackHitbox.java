package Model;

import Interfaces.IObject;

public class AttackHitbox implements IObject {
    private float x;
    private float y;
    private float width;
    private float height;

    /**
     * Constructor for Attack hitboxes
     * @param x float
     * @param y float
     */
    public AttackHitbox(float x, float y){
        this.x = x;
        this.y = y;
        width = 120;
        height = 37;
    }

    /**
     * Gets edges of the hitbox
     * @return float[] with edges of the hitbox
     */
    public float[] getEdges(){
        return new float[] {this.x, this.x+this.width, this.y, this.y+this.height};
    }

    /**
     * Setter for Y position
     * @param y float
     */
    public void setY(float y){
        this.y = y;
    }

    /**
     * Setter for X position
     * @param x float
     */
    public void setX(float x){
        this.x = x;
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public float getHeight() {
        return this.height;
    }

    @Override
    public float getWidth() {
        return this.width;
    }
}
