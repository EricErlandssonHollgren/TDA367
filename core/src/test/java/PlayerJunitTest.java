
import Model.Player;
import Model.Entity;
import com.badlogic.gdx.Gdx;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PlayerJunitTest {

    @Test
    public void playerMoveLeftShouldBeLessThanCurrentPositionIfMoveLeft(){
        Player player = new Player(40f, 50f, 10f, 10f);

        float posX = player.getPosX();
        player.moveLeft();

        assertTrue(player.getPosX() < posX);

    }

    @Test
    public void playerMoveRightShouldBeMoreThanCurrentPositionIfMoveRight(){
        Player player = new Player(40f, 50f, 10f, 10f);

        float posX = player.getPosX();
        player.moveRight();

        assertTrue(player.getPosX() > posX);
    }
}
