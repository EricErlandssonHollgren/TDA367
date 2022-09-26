package View;

import Model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class StatsView {
    private SpriteBatch batch;
    private Texture img;
    private BitmapFont font;
    private MainHandler h1 = new Goldhandler();
    private MainHandler h2 = new PointHandler();

    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
        h1.setSuccessor(h2);
        // Send requests to the chain
        h1.handleRequest(new Request(HandlerItemDefiners.POINTS, 100));
    }



    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ScreenUtils.clear(0, 0, 0, 0);
        batch.begin();
        font.draw(batch, String.valueOf(((Goldhandler)h1).getGold()), 20, 430);
        font.draw(batch, String.valueOf(((PointHandler)h2).getPoints()), 20, 450);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
        font.dispose();
    }
}
