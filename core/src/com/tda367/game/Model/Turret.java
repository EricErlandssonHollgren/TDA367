package com.tda367.game.Model;

import com.tda367.game.Interfaces.Shoot;

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

    public void shootProjectile() {

    }


}
