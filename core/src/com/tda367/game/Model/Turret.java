package Model;

import Interfaces.Shoot;

/*
    This creates a Turret, which requires arguments for its damage, and its shooting speed
     */
public class Turret implements Shoot {
    private double damage;
    private double shootingSpeed;

    public Turret(double damage, double shootingSpeed){
        this.damage = damage;
        this.shootingSpeed = shootingSpeed;
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
