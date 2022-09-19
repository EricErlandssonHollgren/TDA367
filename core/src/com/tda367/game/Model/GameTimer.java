package Model;

import com.badlogic.gdx.Gdx;

public class GameTimer {
    private static GameTimer instance;
    private double timer;
    private GameTimer(){
        this.timer = 0;
    }

    public static GameTimer GetInstance(){
        if(instance == null){
            instance = new GameTimer();
        }
        return instance;
    }
    //Called once every frame input Gdx.graphics.deltaTime from App
    public void UpdateTime(float deltaTime){
        timer += deltaTime;
    }

    public double GetTime(){
        return this.timer;
    }

}
