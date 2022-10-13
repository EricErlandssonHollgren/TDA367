package Model;

import Interfaces.IEnemyAttack;

public class FireAttack implements IEnemyAttack {

    private float x;
    private float y;

    private final float imgWidth;

    private final float imgHeight;
    private final int damage;

    public FireAttack(float x, float y){
        this.x = x;
        this.y = y;
        this.imgWidth = 70;
        this.imgHeight = 70;
        this.damage = 5;
    }

    @Override
    public float getDamage() {
        return this.damage;
    }
    @Override
    public float getX(){
        return this.x;
    }
    @Override
    public float getY(){
        return this.y;
    }

    public float getImgWidth(){
        return imgWidth;
    }

    public float getImgHeight(){
        return imgHeight;
    }
    public void updatePosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
