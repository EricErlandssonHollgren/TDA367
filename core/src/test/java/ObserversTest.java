import Interfaces.IMessageSubscriber;
import Model.MessageSender;
import View.MessageView;
import org.junit.jupiter.api.Test;

public class ObserversTest {

    @Test
    public void TestMessageSender() {
        MessageSender messageSender = MessageSender.GetInstance();
        IMessageSubscriber messageSubscriber = new MessageView();

    }



    /*
           Tower tower = new Tower(new Goldhandler());
        tower.upgrade();
        tower.upgradeTurret(1);
        tower.upgradeTurret(1);
     */
}
