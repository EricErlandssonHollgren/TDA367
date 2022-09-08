package com.tda367.game.Model;

import com.tda367.game.Model.Interfaces.Shoot;

public class Turret implements Shoot {
    private int damage;
    private double shootingSpeed;

    public Turret(int damage, double shootingSpeed){
        this.damage = damage;
        this.shootingSpeed = shootingSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public double getShootingSpeed() {
        return shootingSpeed;
    }



}
