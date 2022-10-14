import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

import Model.*;

public class UiJunitTest {

    @Test
    public void addOneHundredPoints(){
        PointHandler h1 = new PointHandler();
        h1.handleRequest(new Request(HandlerItemDefiners.POINTS, 100));
        assertSame(100, h1.getPoints(), "should be the same");
    }

    @Test
    public void addOneHundredGolds(){
        Goldhandler h1 = new Goldhandler();
        h1.handleRequest(new Request(HandlerItemDefiners.ADDGOLD, 100));
        assertSame(100, h1.getGold(), "should be the same");
    }

    @Test
    public void sendARequest(){
        MainHandler h1 = new Goldhandler();
        MainHandler h2 = new PointHandler();
        h1.setSuccessor(h2);
        h1.handleRequest(new Request(HandlerItemDefiners.POINTS, 100));
        assertSame(100, ((PointHandler)h2).getPoints(), "should be the same");
    }


}
