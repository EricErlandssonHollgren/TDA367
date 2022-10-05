package Model;

import Interfaces.IShoot;
import Interfaces.IUpgradeable;

/**
*A turret class which can shoot projectiles and can be upgraded.
**/

public class Turret implements IShoot, IUpgradeable {
    private int level;
    private double damage;
    private double shootingSpeed;

    /*
    A constructor for the turret.
     */
    public Turret(){
        this.level = 1;
        this.damage = 10;
        this.shootingSpeed = 5;
    }

    /*
    This is going to be a method for the turret to shoot a projectile
     */
    public void shootProjectile() {

    }

    /*
    An upgrade method that when called makes the turret stronger.
     */
    public void upgrade(){
        incrementLevel();
        incrementDamage();
        decrementShootingSpeed();
    }

    /*
    Increments Turret level.
     */
    public void incrementLevel(){
        int newLevel = this.level = getLevel() + 1;
        setLevel(newLevel);
    }

    /*
    Increments Turret damage.
     */
    public void incrementDamage(){
        double newDamage = this.damage = getDamage() + ((getLevel()-1) * 20);
        setDamage(newDamage);
    }

    /*
    Decrements Turret shooting speed, making the Turret shoot faster.
     */
    public void decrementShootingSpeed(){
        double newShootingSpeed = this.shootingSpeed = getShootingSpeed() - ((getLevel() -1) * (getShootingSpeed() * 0.2));
        setShootingSpeed(newShootingSpeed);
    }

    /*
    Gets the current Turret level.
     */
    public int getLevel(){return this.level;}

    /*
    Gets the current Turret damage.
     */
    public double getDamage() {return damage;}

    /*
    Gets the current Turret shooting speed.
     */
    public double getShootingSpeed() {return shootingSpeed;}

    /*
    Sets the current Turret level.
     */
    public void setLevel(int newLevel){this.level = newLevel;}

    /*
    Sets the current Turret damage.
     */
    public void setDamage(double newDamage){this.damage = newDamage;}

    /*
    Sets the current Turret shooting speed.
     */
    public void setShootingSpeed(double newShootingSpeed){this.shootingSpeed = newShootingSpeed;}

}
