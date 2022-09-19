package Model;

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
    //Called once every frame
    public void UpdateTime(double deltaTime){
        timer += deltaTime;
    }

    public double GetTime(){
        return this.timer;
    }

}
