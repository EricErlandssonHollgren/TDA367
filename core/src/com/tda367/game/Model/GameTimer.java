package com.tda367.game.Model;

import com.badlogic.gdx.Gdx;

public class GameTimer {
    private static GameTimer instance;
    private double timer;
    private GameTimer(){
        this.timer = 0;
    }

    public static GameTimer GetInstance(){
        if(instance == null){
            return new GameTimer();
        }
        return instance;
    }
    //Called once every frame
    public void UpdateTime(){
        timer += Gdx.graphics.getDeltaTime();
    }

    public double GetTime(){
        return this.timer;
    }

}
