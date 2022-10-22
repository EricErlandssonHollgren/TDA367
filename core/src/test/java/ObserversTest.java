import Interfaces.IGameOverSubscriber;
import Interfaces.IMessageSubscriber;
import Model.*;
import View.MessageView;
import View.ObserverTestView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObserversTest {

    @Test
    public void TestMessageSender() {
        MessageSender messageSender = MessageSender.GetInstance();
        IMessageSubscriber messageSubscriber = new ObserverTestView();
        messageSender.addSubscribers(messageSubscriber);
        messageSender.sendMessage("Hello");

        assertTrue(((ObserverTestView)messageSubscriber).getMessage() == "Hello");
    }

    @Test
    public void TestMessageSenderTower() {
        MessageSender messageSender = MessageSender.GetInstance();
        IMessageSubscriber messageSubscriber = new ObserverTestView();
        messageSender.addSubscribers(messageSubscriber);
        Goldhandler gh = new Goldhandler();
        gh.handleRequest(new Request(HandlerItemDefiners.GOLD, -1000));
        Tower tower = new Tower(gh);
        tower.upgrade();
        assertTrue(((ObserverTestView)messageSubscriber).getMessage() == "Not enough gold");

        messageSender.sendMessage(null);
        tower.upgradeTurret(1);
        assertTrue(((ObserverTestView)messageSubscriber).getMessage() == "Not enough gold");

        messageSender.sendMessage(null);
        tower.actionHandle(ActionEnum.BUILD);
        assertTrue(((ObserverTestView)messageSubscriber).getMessage() == "Not enough gold");

    }

    @Test
    public void TestGameOver() {
        GameOverInstantiator gameOverInstantiator = GameOverInstantiator.GetInstance();
        IGameOverSubscriber GameOverSubscriber = new ObserverTestView();
        gameOverInstantiator.addSubscribers(GameOverSubscriber);
        gameOverInstantiator.updateGameOverSubscribers();

        assertTrue(((ObserverTestView)GameOverSubscriber).getScreenUpdated());
    }

    @Test
    public void TestGameOverTower() {
        GameOverInstantiator gameOverInstantiator = GameOverInstantiator.GetInstance();
        IGameOverSubscriber GameOverSubscriber = new ObserverTestView();
        gameOverInstantiator.addSubscribers(GameOverSubscriber);
        Tower tower = new Tower(new Goldhandler());
        tower.takeDamage(400);

        assertTrue(((ObserverTestView)GameOverSubscriber).getScreenUpdated());


    }



}
