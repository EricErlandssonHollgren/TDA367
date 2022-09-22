package View;

import Interfaces.IView;
import Model.Enemy.Enemy;
import Model.GameTimer;
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

    private Enemy enemy;
    private SpriteBatch batch;
    private Texture img;

    private GameTimer timer;

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
        float positionX = (float) EnemyFactory.createEnemy1().getPositionX().getX();
        float positionY = (float) EnemyFactory.createEnemy1().getPositionY().getY();
        ScreenUtils.clear(Color.BLACK);
        batch.begin();
        updatePosition(positionX, positionY);
        //batch.draw(img, positionX, positionY, (float) Math.ceil(img.getHeight()*0.2), (float) Math.ceil(img.getWidth()*0.25));
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    public void updatePosition(float x, float y) {
        float newPositionX = x + 1;
        float newPositionY = y +1;
        batch.draw(img, newPositionX, newPositionY, (float) Math.ceil(img.getHeight()*0.2), (float) Math.ceil(img.getWidth()*0.25));

    }
}