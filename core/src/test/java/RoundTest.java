import Model.GameTimer;
import Model.RoundHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoundTest {
    @Test
    public void TimerTest() {
        GameTimer testTimer = GameTimer.GetInstance();
        double startTime = testTimer.GetTime();
        testTimer.UpdateTime(5);
        assertTrue(startTime<testTimer.GetTime());
    }
    @Test
    public void RoundTest(){
        RoundHandler r = RoundHandler.GetInstance();
        GameTimer testTimer = GameTimer.GetInstance();
        double multStart = r.getMultiplier();
        testTimer.UpdateTime(5);
        assertTrue(r.getMultiplier()>multStart);
    }
}
