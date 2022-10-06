package View;
import Interfaces.IEntitySubscriber;
import Interfaces.IView;
import Model.Facade.DrawFacade;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerView implements IView, PlayerPositionSubscriber {
    Sprite playerSprite;
    private Batch batch;
    private Texture texture;

public class PlayerView implements IView, IEntitySubscriber {
    private static Sprite playerSprite;
    private DrawFacade drawFacade;
    float elapsedTime;
    TextureRegion[] animationFrames;
    Animation animation;

    /**
     * A constructor for the playerView. When creating a new playerView it should contain
     * the sprite for the player.
     */

    public PlayerView(){
        drawFacade = new DrawFacade("adventurer-stand-01.png");
        playerSprite = new Sprite();
        batch = new SpriteBatch();
        texture = new Texture("adventurer-stand-01.png");
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

        elapsedTime += Gdx.graphics.getDeltaTime();


        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), playerSprite.getX(), playerSprite.getY());
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
