package View;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import Model.Enemy.EnemyFactory;

/**
 * Is in charge of rendering an enemy on the screen according to LibGDX implementation.
 */
public class RenderEnemy extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture img;

    public void create() {
        batch = new SpriteBatch();
        img = new Texture(Gdx.files.internal(EnemyFactory.createEnemy1().getSpritePath()));
    }

    public void render(float x, float y) {
        ScreenUtils.clear(Color.BLACK);
        batch.begin();
        batch.draw(img, x,y, (float) Math.ceil(img.getHeight()*0.2), (float) Math.ceil(img.getWidth()*0.25));
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
