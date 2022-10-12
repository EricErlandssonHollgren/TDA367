package View;
import Interfaces.IEntitySubscriber;
import Interfaces.IView;
import Model.Facade.AnimationFacade;
import Model.Facade.DrawFacade;
import Model.Player;
import Model.STATE;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerView implements IView, IEntitySubscriber {
    private Batch batch;
    private DrawFacade drawFacade;
    private AnimationFacade animationFacade;
    private float elapsedTime;
    private Texture texture;
    private TextureRegion[] animationFrames;
    Animation animation;
    Player player;

    public Sprite playerSprite;
    /**
     * A constructor for the playerView. When creating a new playerView it should contain
     * the sprite for the player.
     */

    public PlayerView(Player player){
        texture = new Texture("adventurer-stand-01.png");
        drawFacade = new DrawFacade("adventurer-stand-01.png");
        animationFacade = new AnimationFacade("adventurer-stand-01.png");
        playerSprite = new Sprite();
        batch = new SpriteBatch();
        idleAnimation();
        this.player = player;
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
        if (player.getState() == STATE.IDLE)
            idleAnimation();
        else if (player.getState() == STATE.RUNNINGLEFT)
            runningLeftAnimation();
        else if (player.getState() == STATE.RUNNINGRIGHT)
            runningRightAnimation();

        animationFacade.drawAnimation(animation, playerSprite.getX(), playerSprite.getY(), 64,64);
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }

    void runningRightAnimation() {
        animationFrames = new TextureRegion[6];
        animationFrames[0] = new TextureRegion(new Texture("adventurer-run-00.png"));
        animationFrames[1] = new TextureRegion(new Texture("adventurer-run-01.png"));
        animationFrames[2] = new TextureRegion(new Texture("adventurer-run-02.png"));
        animationFrames[3] = new TextureRegion(new Texture("adventurer-run-03.png"));
        animationFrames[4] = new TextureRegion(new Texture("adventurer-run-04.png"));
        animationFrames[5] = new TextureRegion(new Texture("adventurer-run-05.png"));
        animation = new Animation(1f/3f, animationFrames);

    }

    void runningLeftAnimation() {
        animationFrames = new TextureRegion[6];
        animationFrames[0] = new TextureRegion(new Texture("adventurer-run-00.png"));
        animationFrames[1] = new TextureRegion(new Texture("adventurer-run-01.png"));
        animationFrames[2] = new TextureRegion(new Texture("adventurer-run-02.png"));
        animationFrames[3] = new TextureRegion(new Texture("adventurer-run-03.png"));
        animationFrames[4] = new TextureRegion(new Texture("adventurer-run-04.png"));
        animationFrames[5] = new TextureRegion(new Texture("adventurer-run-05.png"));

        for (int i = 0; i < animationFrames.length; i++) {
            animationFrames[i].flip(true, false);
        }
        animation = new Animation(1f/3f, animationFrames);
    }

    void idleAnimation() {
        animationFrames = new TextureRegion[2];
        animationFrames[0] = new TextureRegion(new Texture("adventurer-idle-00.png"));
        animationFrames[1] = new TextureRegion(new Texture("adventurer-idle-01.png"));
        animation = new Animation(1f/2f, animationFrames);
    }

    void attackAnimation() {
        animationFrames = new TextureRegion[5];
        animationFrames[0] = new TextureRegion(new Texture("adventurer-attack1-00.png"));
        animationFrames[1] = new TextureRegion(new Texture("adventurer-attack1-01.png"));
        animationFrames[2] = new TextureRegion(new Texture("adventurer-attack1-02.png"));
        animationFrames[3] = new TextureRegion(new Texture("adventurer-attack1-03.png"));
        animationFrames[4] = new TextureRegion(new Texture("adventurer-attack1-04.png"));
        animation = new Animation(1f/2f, animationFrames);
    }

    void dieAnimation() {
        animationFrames = new TextureRegion[5];
        animationFrames[0] = new TextureRegion(new Texture("adventurer-die-00.png"));
        animationFrames[1] = new TextureRegion(new Texture("adventurer-die-01.png"));
        animationFrames[2] = new TextureRegion(new Texture("adventurer-die-02.png"));
        animationFrames[3] = new TextureRegion(new Texture("adventurer-die-03.png"));
        animationFrames[4] = new TextureRegion(new Texture("adventurer-die-04.png"));
        animationFrames[5] = new TextureRegion(new Texture("adventurer-die-05.png"));
        animationFrames[6] = new TextureRegion(new Texture("adventurer-die-06.png"));
        animation = new Animation(1f/2f, animationFrames);
    }
}
