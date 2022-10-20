package Model;

import Interfaces.IShoot;
import Interfaces.IUpgradeable;

public class Turret implements IShoot, IUpgradeable {
    private int level;
    private double damage;
    private double shootingSpeed;
    private GameTimer timer;
    private boolean hasSpawned;
    /**
     * A constructor for the turret.
     * Turret can shoot projectiles and can be upgraded to be stronger.
     */
    public Turret(){
        this.hasSpawned = false;
        this.level = 1;
        this.damage = 10;
        this.shootingSpeed = 5;
        this.timer = GameTimer.GetInstance();
    }

    /**
     * This is going to be a method for the Turret to shoot a projectile
     */
    public void shootProjectile(){
        if(Math.ceil(timer.GetTime()) % getShootingSpeed() == 0 && !hasSpawned){
            ProjectileFactory.createCannonball(50,250,14,3,10);
            hasSpawned = true;
        }
        if(Math.ceil(timer.GetTime()) % getShootingSpeed() == 2) hasSpawned = false;
    }

    /**
     * An upgrade method that when called makes the Turret stronger.
     */
    public void upgrade(){
        incrementLevel();
        incrementDamage();
        decrementShootingSpeed();
    }

    /**
     * Gets the boolean value that shows if the turret has recently spawned a projectile.
     * @return true/false if turret spawned projectile last render.
     */
    public boolean getHasSpawned() {return hasSpawned;}

    /**
     * Gets the current Turret level.
     * @return the turrets current level.
     */
    public int getLevel(){return this.level;}

    /**
     * Gets the current Turret damage.
     * @return the turrets current damage.
     */
    public double getDamage() {return damage;}

    /**
     * Gets the current Turret shooting speed.
     * @return the turrets current shooting speed.
     */
    public double getShootingSpeed() {return shootingSpeed;}

    // Increments Turret level.
    private void incrementLevel(){
        int newLevel = this.level = getLevel() + 1;
        setLevel(newLevel);
    }

    // Increments Turret damage.
    private void incrementDamage(){
        double newDamage = this.damage = getDamage() + ((getLevel()-1) * 20);
        setDamage(newDamage);
    }

    // Decrements Turret shooting speed, making the Turret shoot faster.
    private void decrementShootingSpeed(){
        double newShootingSpeed = this.shootingSpeed = getShootingSpeed() - ((getLevel() -1) * (getShootingSpeed() * 0.2));
        setShootingSpeed(newShootingSpeed);
    }

    // Sets the current Turret level.
    private void setLevel(int newLevel){this.level = newLevel;}

    // Sets the current Turret damage.
    private void setDamage(double newDamage){this.damage = newDamage;}

    //Sets the current Turret shooting speed.
    private void setShootingSpeed(double newShootingSpeed){this.shootingSpeed = newShootingSpeed;}

}
