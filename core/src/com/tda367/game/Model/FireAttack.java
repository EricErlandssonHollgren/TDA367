package Model;

import Interfaces.IProjectile;

public class FireAttack implements IProjectile {

    private float x;
    private float y;
    private long latestAttackTime;

    private final float imgWidth;

    private final int damage;

    public FireAttack(float x, float y) {
        this.x = x;
        this.y = y;
        this.imgWidth = 100;
        this.damage = 5;
    }

    public float getDamage() {
        return this.damage;
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
    public float getRadius() {
        return imgWidth/2;
    }

    @Override
    public void move() {
        this.x -= 0.2;
    }

    public void fireAttack(Entity player){
        long currentAttackTime = System.currentTimeMillis();
        long minIntervalbetweenAttack = 3000;
        if (currentAttackTime > latestAttackTime + minIntervalbetweenAttack) {
            player.takeDamage(damage);
            latestAttackTime = currentAttackTime;
        }
    }

}
