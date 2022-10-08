package Model;

import Interfaces.IProjectile;

public class FireBall implements IProjectile {

    private float positionX;
    private float positionY;
    private float radius;
    private final int damage;

    public FireBall(float positionX, float positionY, float radius, int damage){
        this.positionX = positionX;
        this.positionY = positionY;
        this.radius = radius;
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
    @Override
    public float getRadius() {
        return this.radius;
    }
    @Override
    public void move(){
    }

}
