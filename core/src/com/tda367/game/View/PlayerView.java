package View;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import Interfaces.PlayerPositionSubscriber;
import Model.Player;

public class PlayerView implements PlayerPositionSubscriber {
    Sprite playerSprite;

    /**
     * A constructor for the playerView. When creating a new playerView it should contain
     * the sprite for the player.
     */
    public PlayerView(){
        this.playerSprite = new Sprite(getPlayerTexture());
    }

    /**
     * The draw method for a playerSprite should draw the player.
     * @param playerBatchSprite is the batch of a player
     */
    public void draw(Batch playerBatchSprite) {
        playerSprite.draw(playerBatchSprite);
    }

    /**
     *Method should be creating the character's look
     * @return the characters texture
     */
    public Texture getPlayerTexture(){
        //TODO: Using this for now
        return new Texture("adventurer-stand-01.png");
    }

    /**
     * The updatePosition should set the sprite of a player's x and y coordinates.
     * @param x is the coordinate on the x-axis
     * @param y is the coordinate on the y-axis
     */
    @Override
    public void updatePosition(float x, float y) {
        playerSprite.setPosition(x,y);
    }
}
