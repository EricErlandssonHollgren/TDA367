package Model;

public class RoundHandler {
    private static RoundHandler instance;
    private GameTimer timer;

    private RoundHandler(){
        timer = GameTimer.GetInstance();
    }

    public static RoundHandler GetInstance(){
        if(instance == null){
            instance = new RoundHandler();
        }
        return instance;
    }

    //Get multiplier for Hp, points and gold
    public double getMultiplier(){
        return Math.exp(timer.GetTime()/600);
    }
}
