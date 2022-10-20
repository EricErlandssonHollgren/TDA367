package Model;

import Interfaces.IPaus;

public class GameTimer implements IPaus {
    private static GameTimer instance;
    private double timer;
    private boolean isGamePaused = false;
    private GameTimer(){
        this.timer = 0;
    }

    /**
     * Creates instance of game timer
     * @return instance
     */
    public static GameTimer GetInstance(){
        if(instance == null){
            instance = new GameTimer();
        }
        return instance;
    }

    /**
     * Called once every frame from app
     * @param deltaTime the difference in time
     */
    public void UpdateTime(double deltaTime){
        if (!isGamePaused) {
            timer += deltaTime;
        }
    }

    /**
     * Getter for getting the time
     * @return timer
     */
    public double GetTime(){
        return this.timer;
    }

    /**
     * Resets the timer.
     */
    public void ResetTime() {timer = 0;}

    @Override
    public void IsGamePaused(boolean isGamePaused) {
        this.isGamePaused = isGamePaused;
    }
}
