package View;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import Interfaces.PlayerPositionSubscriber;
import Model.Player;

public class PlayerView implements PlayerPositionSubscriber {
    Sprite playerSprite;
    Player player;

    public PlayerView(Player player){
        this.player = player;
        this.playerSprite = new Sprite(getPlayerTexture());
    }

    public void draw(Batch playerBatchSprite) {
        playerSprite.draw(playerBatchSprite);
    }

    public Texture getPlayerTexture(){
        //TODO: Using this for now
        return new Texture("adventurer-stand-01.png");
    }

    @Override
    public void updatePosition(float x, float y) {
        playerSprite.setPosition(x,y);
    }
}
