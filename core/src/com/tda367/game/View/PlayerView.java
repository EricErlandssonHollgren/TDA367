package View;
import Interfaces.IEntitySubscriber;
import Interfaces.IView;
import Model.Facade.DrawFacade;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

public class PlayerView implements IView, IEntitySubscriber {
    private Batch batch;
    private static Sprite playerSprite;
    private DrawFacade drawFacade;
    float elapsedTime;
    private Texture texture;
    TextureRegion[] animationFrames;
    Animation animation;

    /**
     * A constructor for the playerView. When creating a new playerView it should contain
     * the sprite for the player.
     */

    public PlayerView(){
        playerSprite = new Sprite();
        batch = new SpriteBatch();
        texture = new Texture("adventurer-stand-01.png");

        animationFrames = new TextureRegion[6];
        animationFrames[0] = new TextureRegion(new Texture("adventurer-run-00.png"));
        animationFrames[1] = new TextureRegion(new Texture("adventurer-run-01.png"));
        animationFrames[2] = new TextureRegion(new Texture("adventurer-run-02.png"));
        animationFrames[3] = new TextureRegion(new Texture("adventurer-run-03.png"));
        animationFrames[4] = new TextureRegion(new Texture("adventurer-run-04.png"));
        animationFrames[5] = new TextureRegion(new Texture("adventurer-run-05.png"));



        animation = new Animation(1f/3f, animationFrames);
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
        //drawFacade.drawObject(playerSprite.getX(), playerSprite.getY(), 64, 64);

        elapsedTime += Gdx.graphics.getDeltaTime();

        batch.begin();
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), playerSprite.getX(), playerSprite.getY());
        batch.end();
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
