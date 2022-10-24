import Model.GameTimer;
import Model.RoundHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoundHandlerTest {
    @Test
    public void TestTimer(){
        GameTimer testTimer = GameTimer.GetInstance();
        double time = testTimer.GetTime();
        testTimer.UpdateTime(5);
        assertTrue(time < testTimer.GetTime());
    }
    @Test
    public void TestRound(){
        GameTimer t = GameTimer.GetInstance();
        RoundHandler r = new RoundHandler(t);
        double mult = r.getMultiplier();
        t.UpdateTime(5);
        assertTrue(mult < r.getMultiplier());
    }
}
