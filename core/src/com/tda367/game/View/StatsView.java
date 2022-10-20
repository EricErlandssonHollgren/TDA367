package View;

import Interfaces.IView;
import Model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class StatsView implements IView {
    private SpriteBatch batch;
    private Texture img;
    private BitmapFont font;
    private MainHandler h1 = new Goldhandler();
    private MainHandler h2 = new PointHandler();

    /**
     * Constructor for the statsview
     */
    public StatsView(){
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
        h1.setSuccessor(h2);
        // Send requests to the chain
        h1.handleRequest(new Request(HandlerItemDefiners.POINTS, 100));
    }

    @Override
    public void render() {
        batch.begin();
        font.draw(batch, String.valueOf(((Goldhandler)h1).getGold()), 20, 430);
        font.draw(batch, String.valueOf(((PointHandler)h2).getPoints()), 20, 450);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
