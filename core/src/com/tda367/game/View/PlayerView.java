package View;
import Interfaces.IView;
import Model.ActionEnum;
import Model.Facade.AnimationFacade;
import Model.Facade.DrawFacade;
import Model.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

public class PlayerView implements IView {
    private Batch batch;
    private DrawFacade drawFacade;
    private AnimationFacade animationFacade;
    private float elapsedTime;
    private Texture texture;
    private TextureRegion[] animationFrames;
    private Animation animation;
    private Player player;
    /**
     * A constructor for the playerView. When creating a new playerView it should contain
     * the sprite for the player.
     */

    public PlayerView(Player player){
        drawFacade = new DrawFacade();
        this.player = player;
    }


    /**
     * Render for the player sprite which paints the player sprite's texture
     */
    @Override
    public void render() {
        drawFacade.setTexture("adventurer-stand-01.png");
        drawFacade.drawObject(player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight());
        drawFacade.drawAnimation(animation, playerSprite.getX(), playerSprite.getY(), 64, 64);
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

    void hurAnimation() {
        animationFrames = new TextureRegion[3];
        animationFrames[0] = new TextureRegion(new Texture("adventurer-hurt-00.png"));
        animationFrames[0] = new TextureRegion(new Texture("adventurer-hurt-01.png"));
        animationFrames[0] = new TextureRegion(new Texture("adventurer-hurt-02.png"));
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
