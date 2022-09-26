package View;
import Interfaces.IRectangle;
import Interfaces.IView;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import Interfaces.IPlayerSubscriber;
import Model.Player;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
     * The updatePosition should set the sprite of a player's x and y coordinates.
     * @param x is the coordinate on the x-axis
     * @param y is the coordinate on the y-axis
     */
    @Override
    public void updatePosition(float x, float y) {
        playerSprite.setPosition(x,y);
    }
    @Override
    public void updateMovement(){

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
