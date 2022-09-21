package View;

import Interfaces.IView;
import Model.Enemy.Enemy;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import Model.Enemy.EnemyFactory;

/**
 * Is in charge of rendering an enemy on the screen according to LibGDX implementation.
 */
public class EnemyView implements IView {

    private Enemy enemy;
    private SpriteBatch batch;
    private Texture img;

    /**
     * A constructor for creating an Enemy.
     */
    public EnemyView(Enemy enemy) {
        this.enemy = enemy;
        batch = new SpriteBatch();
        img = new Texture(Gdx.files.internal(EnemyFactory.createEnemy1().getSpritePath()));
    }
    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);
        batch.begin();
        batch.draw(img, 300, 0, (float) Math.ceil(img.getHeight()*0.2), (float) Math.ceil(img.getWidth()*0.25));
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
