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

    public FireAttack() {
        this.x = 630;
        this.y = 100;
        this.imgWidth = 70;
        this.imgHeight = 70;
        this.damage = 20;
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

    @Override
    public float getWidth() {
        return imgWidth;
    }

    @Override
    public float getHeight(){
        return imgHeight;
    }

    @Override
    public void fireAttackAtPlayer(Entity player){
        long currentAttackTime = System.currentTimeMillis();
        long minIntervalbetweenAttack = 3000;
        if (currentAttackTime > latestAttackTime + minIntervalbetweenAttack) {
            player.takeDamage(damage);
            latestAttackTime = currentAttackTime;
        }
    }

    @Override
    public void fireAttackAtTower(Tower tower){
        long currentAttackTime = System.currentTimeMillis();
        long minIntervalbetweenAttack = 3000;
        if(currentAttackTime > latestAttackTime + minIntervalbetweenAttack){
            tower.takeDamage(damage);
            latestAttackTime = currentAttackTime;
        }
    }
}
