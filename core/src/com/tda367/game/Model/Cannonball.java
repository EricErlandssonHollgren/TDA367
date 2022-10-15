package Model;

import Interfaces.IProjectile;

public class Cannonball implements IProjectile {
    private float x,y,vx,vy,gravity, radius;
    private int damage;
    private long latestAttackTime;

    public Cannonball(float x, float y, float vx, float vy, float gravity, float damage, float radius){
        this.gravity = gravity;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.damage = 20;
    }

    @Override
    public void projectileAttack(Entity enemy) {
        long currentAttackTime = System.currentTimeMillis();
        long minIntervalbetweenAttack = 1000;
        if (currentAttackTime > latestAttackTime + minIntervalbetweenAttack) {
            enemy.takeDamage(damage);
            latestAttackTime = currentAttackTime;
        }

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
    public float getRadius() {
        return this.radius;
    }

    @Override
    public void move(){
        vy += gravity;
        x += vx;
        y += vy;
    }
}
