import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Model.*;

public class UiJunitTest {

    @Test
    public void addOneHundredPoints(){
        PointHandler h1 = new PointHandler();
        int pointsBefore = h1.getPoints();
        h1.handleRequest(new Request(HandlerItemDefiners.POINTS, 100));
        h1.getPoints();
        assertTrue(pointsBefore+100 == h1.getPoints());
    }

    @Test
    public void addOneHundredGolds(){
        Goldhandler h1 = new Goldhandler();
        int goldBefore = h1.getGold();
        h1.handleRequest(new Request(HandlerItemDefiners.GOLD, 100));
        assertTrue(goldBefore+100 == h1.getGold());
    }

    @Test
    public void sendARequest(){
        MainHandler h1 = new Goldhandler();
        MainHandler h2 = new PointHandler();
        int pointsBefore = ((PointHandler) h2).getPoints();
        h1.setSuccessor(h2);
        h1.handleRequest(new Request(HandlerItemDefiners.POINTS, 100));
        assertTrue(pointsBefore+100 == ((PointHandler)h2).getPoints());
    }

    @Test
    public void sendARequest2(){
        MainHandler h2 = new Goldhandler();
        MainHandler h1 = new PointHandler();
        int goldBefore = ((Goldhandler) h2).getGold();
        h1.setSuccessor(h2);
        h1.handleRequest(new Request(HandlerItemDefiners.GOLD, 100));
        assertTrue(goldBefore+100 == ((PointHandler)h2).getPoints());
    }
}
