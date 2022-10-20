package Model;

public class RoundHandler {
    private GameTimer timer;

    /**
     * Constructor for RoundHandler
     * @param timer instance of GameTimer
     */
    public RoundHandler(GameTimer timer){
        this.timer = timer;
    }

    /**
     * Gets the multiplier that enemies use
     * @return a value with the multiplier
     */
    public double getMultiplier(){
        return Math.exp(timer.GetTime()/600);
    }
}
