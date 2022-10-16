
import Model.ActionEnum;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import Model.Entity;
import Model.EntityHolder;
import Model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PlayerJunitTest {

    @Test
    public void playerMoveLeftShouldBeLessThanCurrentPositionIfMoveLeft(){
        Player player = new Player(200,100, 50 ,37);

        float posX = player.getPosX();
        player.moveLeft();

        assertTrue(player.getPosX() < posX);

    }

    @Test
    public void playerMoveRightShouldBeMoreThanCurrentPositionIfMoveRight(){
        Player player = new Player(9,100, 50 ,37);

        float posX = player.getPosX();
        player.moveRight();

        assertTrue(player.getPosX() > posX);
    }
    @Test
    public void notableToMoveRight(){
        boolean isAbleToMoveRight = false;

        Player player = new Player(200, 100, 50, 37);

        boolean checkPlayerMoveRight= player.setAbleToMoveRight(isAbleToMoveRight);
        assertFalse(player.setAbleToMoveRight(checkPlayerMoveRight));
    }

    @Test
    public void notableToMoveLeft(){
        boolean isAbleToMoveLeft = false;

        Player player = new Player(200, 100, 50, 37);

        boolean checkPlayerMoveLeft= player.setAbleToMoveLeft(isAbleToMoveLeft);
        assertFalse(player.setAbleToMoveRight(checkPlayerMoveLeft));

    }

    @Test
    public void playerTakingDamage(){
        Player player = new Player(200, 100, 50, 37);

        player.takeDamage(20);
        int health = player.getHealth();
        assertTrue(health < 100);
    }

    @Test
    public void dealingDamage() throws InterruptedException {
        Player player = new Player(200, 100, 50, 37);
        Enemy enemy = EnemyFactory.createEnemy1();
        EntityHolder.getInstance().addEntity(enemy);
        int initialEnemyHealth = enemy.getHealth();

        Thread.sleep(1000);
        player.actionHandle(ActionEnum.DAMAGE);
        player.playerAttack(enemy);
        int newEnemyHealth = enemy.getHealth();
        assertTrue(initialEnemyHealth > newEnemyHealth);

    }

}
