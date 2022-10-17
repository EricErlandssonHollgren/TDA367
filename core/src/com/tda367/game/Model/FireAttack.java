package Model;

import Interfaces.IEnemyAttack;
import Interfaces.IProjectile;

public class FireAttack implements IEnemyAttack {

    private float x;
    private float y;
    private long latestAttackTime;

    private final float imgWidth;
    private final float imgHeight;

    private final int damage;

    public FireAttack(float x, float y) {
        this.x = x;
        this.y = y;
        this.imgWidth = 70;
        this.imgHeight = 70;
        this.damage = 5;
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
    public void move() {
        double speed = 0.5;
        this.x -= speed;
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
