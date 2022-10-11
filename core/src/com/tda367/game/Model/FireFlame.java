package Model;

import Interfaces.IEnemyAttack;

public class FireFlame implements IEnemyAttack {

    private float positionX;
    private float positionY;
    private final int damage;

    public FireFlame(float positionX, float positionY, int damage){
        this.positionX = positionX;
        this.positionY = positionY;
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

}
