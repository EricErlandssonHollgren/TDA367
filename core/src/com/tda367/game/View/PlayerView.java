package View;
import Interfaces.IRectangle;
import Interfaces.IView;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import Interfaces.IPlayerSubscriber;
import Model.Player;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class PlayerView implements IView, IPlayerSubscriber{
    private static Sprite playerSprite;
    private static Batch batch;
    private static Texture texture;
    private Player player;
    /**
     * A constructor for the playerView. When creating a new playerView it should contain
     * the sprite for the player.
     */
    public PlayerView(){
        playerSprite = new Sprite();
        batch = new SpriteBatch();
        texture = new Texture("adventurer-stand-01.png");

    }

    /**
     * The updatePosition should update the sprite of a player's position
     * x and y coordinates.
     * @param pos is the position which can either set the x or y.
     */
    @Override
    public void updatePosition(Vector2 pos) {
        playerSprite.setPosition(pos.x, pos.y);
    }


    public Player getPlayer() {
        return player;
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(texture, playerSprite.getX(), playerSprite.getY());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

}
