package com.tda367.game.Model.Enemy;

public abstract class Enemy {
    private int worth;
    private int HP;

    private String projectile;

    private String spritePath;

    public Enemy(int worth, int HP, String projectile, String spritePath) {
        this.worth = worth;
        this.HP = HP;
        this.projectile = projectile;
        this.spritePath = spritePath;
    }

    public int getWorth() {
        return worth;
    }

    public int getHP() {
        return HP;
    }

    public String getSpritePath() {
        return spritePath;
    }
}
