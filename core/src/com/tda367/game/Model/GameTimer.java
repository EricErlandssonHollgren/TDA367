package Model;

public class GameTimer {
    private static GameTimer instance;
    private double timer;
    public GameTimer(){
        this.timer = 0;
    }

    public static GameTimer GetInstance() {
        if(instance == null){
            instance = new GameTimer();
        }
        return instance;
    }
    //Called once every frame from app do not use
    public void UpdateTime(double deltaTime){
        timer += deltaTime;
    }
    //Gets the time
    public double GetTime(){
        return this.timer;
    }

}
