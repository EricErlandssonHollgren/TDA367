import Controller.PausController;
import Interfaces.IMessageSubscriber;
import Interfaces.IPaus;
import Interfaces.IView;
import View.GameView;
import View.MessageView;
import View.PausView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        MainHandler h1 = new PointHandler();
        MainHandler h2 = new Goldhandler();
        h1.setSuccessor(h2);
        int goldBefore = ((Goldhandler) h2).getGold();
        h1.handleRequest(new Request(HandlerItemDefiners.GOLD, 100));
        int goldAfter = ((Goldhandler)h2).getGold();
        assertTrue(goldBefore+100 == goldAfter);
    }
    
    @Test
    public void testPause() {
        Waves wave = new Waves();
        wave.IsGamePaused(true);
        int amaount = wave.getQueue().size();
        List<Entity> enemies = wave.getEnemiesToRender();
        assertTrue(wave.getQueue().size() == amaount);

        Player player = new Player(120, 100, 50, 37, 125);
        player.IsGamePaused(true);
        float x = player.getPosX();
        player.actionHandle(ActionEnum.LEFT);
        assertTrue(x == player.getPosX());

        GameTimer timer = GameTimer.GetInstance();
        double t = timer.GetTime();
        timer.IsGamePaused(true);
        timer.UpdateTime(5);
        assertTrue(t == timer.GetTime());
        timer.IsGamePaused(false);


        Goldhandler goldhandler = new Goldhandler();
        Tower tower = new Tower(goldhandler);
        double before = tower.getHealth();
        tower.IsGamePaused(true);
        tower.takeDamage(10);
        assertTrue(tower.getHealth() == before);

        Cannonball cannonball = new Cannonball(10,10,10,10,10,10,10);
        cannonball.IsGamePaused(true);
        x = cannonball.getX();
        float y = cannonball.getY();
        timer.UpdateTime(10);
        cannonball.move();
        assertTrue(cannonball.getX() == x);
        assertTrue(cannonball.getY() == y);

        Enemy enemy = new Enemy(10,10,10, AttackFactory.createFireFlame(630,100) ,100);
        enemy.IsGamePaused(true);
        enemy.takeDamage(100);
        assertTrue(enemy.getHealth() == 100);
    }
}
