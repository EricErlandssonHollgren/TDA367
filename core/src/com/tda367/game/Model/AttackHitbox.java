package Model;

import Interfaces.IObject;

public class AttackHitbox implements IObject {
    private float x;
    private float y;
    private float width;
    private float height;

    public AttackHitbox(float x, float y){
        this.x = x;
        this.y = y;
        width = 120;
        height = 37;
    }
    public float[] getEdges(){
        return new float[] {this.x, this.x+this.width, this.y, this.y+this.height};
    }

    public void setY(float y){
        this.y = y;
    }

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
