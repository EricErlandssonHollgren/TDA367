package View;

import Interfaces.IEnemy;
import Interfaces.IView;
import Model.Enemy.Enemy;
import Model.GameTimer;
import Model.RoundHandler;
import Model.Waves;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import Model.Enemy.EnemyFactory;

import java.awt.geom.Point2D;

/**
 * Is in charge of rendering an enemy on the screen according to LibGDX implementation.
 */
public class EnemyView implements IView {

    private IEnemy enemy;

    //private Enemy enemy;
    private SpriteBatch batch;

    private Waves wave;
    private Texture img;

    /**
     * A constructor for creating an Enemy.
     */
    public EnemyView(IEnemy enemy) {
        this.enemy = enemy;
        batch = new SpriteBatch();
        img = new Texture(this.enemy.getTexturePath());
        wave = new Waves();
    }
    @Override
    public void render() {
        float positionX = enemy.getX().x;
        float positionY = enemy.getY().y;
        batch.begin();
        enemy.move();
        batch.draw(img, positionX, positionY, (float) Math.ceil(img.getHeight()*0.15), (float) Math.ceil(img.getWidth()*0.25));
        //wave.spawnWave();
        batch.end();
    }
    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
