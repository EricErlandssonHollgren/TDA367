package Model;

import Interfaces.IEnemyAttack;

public class FireFlame implements IEnemyAttack {

    private float positionX;
    private float positionY;

    private float imgWidth;

    private float imgHeight;
    private final int damage;

    public FireFlame(float positionX, float positionY, float imgWidth, float imgHeight, int damage){
        this.positionX = positionX;
        this.positionY = positionY;
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        this.damage = damage;
    }

    @Override
    public float getDamage() {
        return this.damage;
    }
    @Override
    public float getX(){
        return this.positionX;
    }
    @Override
    public float getY(){
        return this.positionY;
    }

    public void updatePosition(float x, float y) {
        positionX = x-100;
        positionY = y;
    }

}
