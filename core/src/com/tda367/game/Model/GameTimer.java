package Model;

public class GameTimer {
    private static GameTimer instance;
    private double timer;
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
        timer += deltaTime;
    }

    /**
     * Getter for getting the time
     * @return timer
     */
    public double GetTime(){
        return this.timer;
    }

}
