package View;
import Interfaces.IView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import Interfaces.PlayerPositionSubscriber;
import Model.Player;
import com.badlogic.gdx.utils.ScreenUtils;

public class PlayerView implements IView, PlayerPositionSubscriber {
    Sprite playerSprite;
    private Batch batch;
    private Texture texture;

    float elapsedTime;
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
     * The updatePosition should set the sprite of a player's x and y coordinates.
     * @param x is the coordinate on the x-axis
     * @param y is the coordinate on the y-axis
     */
    @Override
    public void updatePosition(float x, float y) {
        playerSprite.setPosition(x,y);
    }



    @Override
    public void render() {
        elapsedTime += Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0, 0, 0, 0);
        batch.begin();

        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), playerSprite.getX(), playerSprite.getY());

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }


}
