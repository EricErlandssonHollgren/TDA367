import org.junit.jupiter.api.Test;
import Model.*;

public class UiJunitTest {

    @Test
    public void addOneHundredPoints(){
        PointHandler h1 = new PointHandler();
        h1.handleRequest(new Request(HandlerItemDefiners.POINTS, 100));

        //assertSame("should be same", 100, h1.getPoints());
    }


}
