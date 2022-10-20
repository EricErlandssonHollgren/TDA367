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

    /**
     * Constructor for creating a fire attack at a specific position.
     * @param x the x-position for the fire attack
     * @param y the y-position for the fire attack
     */
    public FireAttack(float x, float y) {
        this.x = x;
        this.y = y;
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
    public void move(double velocity) {
        this.x -= velocity;
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
    public int getDamage(){
        return damage;
    }

    @Override
    public void attackAtPlayer(Entity player){
        long currentAttackTime = System.currentTimeMillis();
        long minIntervalbetweenAttack = 3000;
        if (currentAttackTime > latestAttackTime + minIntervalbetweenAttack) {
            player.takeDamage(damage);
            latestAttackTime = currentAttackTime;
        }
    }

    @Override
    public void attackAtTower(Tower tower){
        long currentAttackTime = System.currentTimeMillis();
        long minIntervalbetweenAttack = 3000;
        if(currentAttackTime > latestAttackTime + minIntervalbetweenAttack){
            tower.takeDamage(damage);
            latestAttackTime = currentAttackTime;
        }
    }
}
