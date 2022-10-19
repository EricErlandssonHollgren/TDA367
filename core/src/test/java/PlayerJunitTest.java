
import Interfaces.IEnemyAttack;
import Model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PlayerJunitTest {

    @Test
    public void playerMoveLeftShouldBeLessThanCurrentPositionIfMoveLeft(){
        Player player = new Player(200,100, 50 ,37, 125);

        float posX = player.getPosX();
        player.moveLeft();

        assertTrue(player.getPosX() < posX);

    }

    @Test
    public void playerMoveRightShouldBeMoreThanCurrentPositionIfMoveRight(){
        Player player = new Player(9,100, 50 ,37, 125);

        float posX = player.getPosX();
        player.moveRight();

        assertTrue(player.getPosX() > posX);
    }
    @Test
    public void notableToMoveRight(){
        boolean isAbleToMoveRight = false;

        Player player = new Player(200, 100, 50, 37,125);

        boolean checkPlayerMoveRight= player.setAbleToMoveRight(isAbleToMoveRight);
        assertFalse(player.setAbleToMoveRight(checkPlayerMoveRight));
    }

    @Test
    public void notableToMoveLeft(){
        boolean isAbleToMoveLeft = false;

        Player player = new Player(200, 100, 50, 37,125);

        boolean checkPlayerMoveLeft= player.setAbleToMoveLeft(isAbleToMoveLeft);
        assertFalse(player.setAbleToMoveRight(checkPlayerMoveLeft));

    }

    @Test
    public void playerTakingDamage(){
        Player player = new Player(200, 100, 50, 37,125);
        int initialHealth = player.getHealth();
        player.takeDamage(20);
        int newHealth = player.getHealth();
        assertTrue(initialHealth > newHealth);
    }

    @Test
    public void dealingDamage() throws InterruptedException {
        Player player = new Player(200, 100, 50, 37,125);
        Enemy enemy = new Enemy(630, 100,10,AttackFactory.createFireFlame(630,100),125);
        EntityHolder.getInstance().addEntity(enemy);
        int initialEnemyHealth = enemy.getHealth();

        Thread.sleep(1000);
        player.actionHandle(ActionEnum.DAMAGE);
        player.playerAttack(enemy);
        int newEnemyHealth = enemy.getHealth();
        assertTrue(initialEnemyHealth > newEnemyHealth);
    }

}
