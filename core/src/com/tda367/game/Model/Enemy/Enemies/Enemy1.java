package com.tda367.game.Model.Enemy.Enemies;

import com.tda367.game.Model.Enemy.Enemy;

public class Enemy1 extends Enemy {

    static final int worth = 5;
    static final int HP = 5;
    static final String projectile = "bomb";
    static final String spritePath = "koopaTroopa.png";

    public Enemy1() {
        super(worth, HP, projectile, spritePath);
    }

    public String getSpritePath() {
        return spritePath;
    }
}
