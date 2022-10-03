package test.java;

import Model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PlayerJunitTest {

    @Test
    public void playerMoveLeftShouldBeLessThanCurrentPositionIfMoveLeft(){
        Player player = new Player(9,100);

        float posX = player.getPosX();
        player.moveLeft();

        assertTrue(player.getPosX() < posX);

    }

    @Test
    public void playerMoveRightShouldBeMoreThanCurrentPositionIfMoveRight(){
        Player player = new Player(9,100);

        float posX = player.getPosX();
        player.moveRight();

        assertTrue(player.getPosX() > posX);
    }
}
