package Model;

import Interfaces.IPaus;

public class GameTimer implements IPaus {
    private static GameTimer instance;
    private double timer;
    public GameTimer(){
        this.timer = 0;
    }
    private boolean isGamePaused = false;

    public static GameTimer GetInstance() {
        if(instance == null){
            instance = new GameTimer();
        }
        return instance;
    }
    //Called once every frame from app do not use
    public void UpdateTime(double deltaTime){
        if (!isGamePaused) {
            timer += deltaTime;
        }
    }
    //Gets the time
    public double GetTime(){
        return this.timer;
    }

    public void ResetTime() {timer = 0;}

    @Override
    public void IsGamePaused(boolean isGamePaused) {
        this.isGamePaused = isGamePaused;
    }
}
