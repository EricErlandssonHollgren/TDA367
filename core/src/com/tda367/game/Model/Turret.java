package Model;

import Interfaces.IShoot;

/*
    This creates a Turret, which requires arguments for its damage, and its shooting speed
     */
public class Turret implements IShoot{
    private final double damage;
    private final double shootingSpeed;

    public Turret(){
        this.damage = 10;
        this.shootingSpeed = 5;
    }

    public double getDamage() {
        return damage;
    }

    public double getShootingSpeed() {
        return shootingSpeed;
    }

    /*
    This is going to be a method for the turret to shoot a projectile
     */
    public void shootProjectile() {

    }
}
