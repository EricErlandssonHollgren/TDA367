package View;
import Controller.KeyListener;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import Interfaces.PlayerPositionSubscriber;
import Model.Player;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PlayerView extends ApplicationAdapter implements PlayerPositionSubscriber {
    private Sprite playerSprite;
    private SpriteBatch batch;
    private Player player;
    private Texture texture;
    private KeyListener keyListener;
    /**
     * A constructor for the playerView. When creating a new playerView it should contain
     * the player and a sprite for the player.
     * @param player represents the player
     */
    public PlayerView(Player player){
        this.player = player;
        this.playerSprite = new Sprite();
    }

    public void create(){
        batch = new SpriteBatch();
        player = new Player(40f, 50f);
        texture = new Texture("adventurer-stand-01.png");
        keyListener = new KeyListener(player);
    }

    public void render(){
        ScreenUtils.clear(0, 0, 0, 0);
        batch.begin();
        batch.draw(texture, player.getPosX(), player.getPosY());
        keyListener.UpdatePlayerPosition();
        batch.end();
    }

    public void dispose(){
        batch.dispose();

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
