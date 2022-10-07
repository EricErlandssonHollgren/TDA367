package View;
import Interfaces.IView;
import Model.Facade.DrawFacade;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import Interfaces.IPlayerSubscriber;


public class PlayerView implements IView, IPlayerSubscriber{
    public Sprite playerSprite;
    private static Texture texture;
    private DrawFacade drawFacade;
    /**
     * A constructor for the playerView. When creating a new playerView it should contain
     * the sprite for the player.
     */

    public PlayerView(){
        texture = new Texture("adventurer-stand-01.png");
        drawFacade = new DrawFacade("adventurer-stand-01.png");
        playerSprite = new Sprite();
    }

    /**
     * Updates the position of a player's sprite
     * @param x is the player sprite's x-coordinate
     * @param y is the player sprite's y-coordinate
     */
    @Override
    public void updatePosition(float x, float y) {
        playerSprite.setPosition(x, y);
    }


    /**
     * Render for the player sprite which paints the player sprite's texture
     */
    @Override
    public void render() {
        drawFacade.drawObject(playerSprite.getX(), playerSprite.getY(), 64, 64);

    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }

}
