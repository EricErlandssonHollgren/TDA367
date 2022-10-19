package Model;

public class RoundHandler {
    private GameTimer timer;

    public RoundHandler(GameTimer timer){
        this.timer = timer;
    }

    //Get multiplier for Hp, points and gold
    public double getMultiplier(){
        return Math.exp(timer.GetTime()/600);
    }
}
