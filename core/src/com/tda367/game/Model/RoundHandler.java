package com.tda367.game.Model;

import com.badlogic.gdx.Gdx;

public class RoundHandler {
    private static RoundHandler instance;
    private float multiplier;
    private GameTimer timer;

    private RoundHandler(){
        timer = GameTimer.GetInstance();
        this.multiplier = 1;
    }

    public static RoundHandler GetInstance(){
        if(instance == null){
            return new RoundHandler();
        }
        return instance;
    }

    //Get multiplier for Hp, points and gold
    public double getMultiplier(){
        return Math.exp(timer.GetTime()/600);
    }
}

