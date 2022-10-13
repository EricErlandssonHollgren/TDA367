package Model;

import Interfaces.IEnemyAttack;
import Interfaces.IObject;

public class FireAttack implements IEnemyAttack, IObject {

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

    @Override
    public float getHeight() {
        return imgHeight;
    }

    @Override
    public float getWidth() {
        return imgWidth;
    }

    public void updatePosition(float x, float y) {
        this.x = x;
        this.y = y;
    }



}
