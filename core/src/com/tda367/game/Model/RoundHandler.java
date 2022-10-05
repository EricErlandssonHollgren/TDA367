package Model;

public class RoundHandler {
    private static RoundHandler instance;
    private GameTimer timer;

    private RoundHandler(GameTimer timer){
        this.timer = timer;
    }

    public static RoundHandler GetInstance(GameTimer timer){
        if(instance == null){
            instance = new RoundHandler(timer);
        }
        return instance;
    }

    //Get multiplier for Hp, points and gold
    public double getMultiplier(){
        return Math.exp(timer.GetTime()/600);
    }
}
