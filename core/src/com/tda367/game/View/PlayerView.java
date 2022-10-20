package View;
import Interfaces.IView;
import Model.Facade.DrawFacade;
import Model.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

public class PlayerView implements IView {
    private Batch batch;
    private DrawFacade drawFacade;
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
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }

}
