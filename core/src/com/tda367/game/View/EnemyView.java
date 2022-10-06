package View;

import Interfaces.*;
import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import Model.Facade.DrawFacade;
import Model.GameTimer;
import Model.Waves;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Is in charge of rendering an enemy on the screen according to LibGDX implementation.
 */
public class EnemyView implements IView, IEnemySubscriber {

    private Waves wave;
    private Texture img;

    private DrawFacade drawFacade;


    /**
     * A constructor for creating an Enemy.
     */
    public EnemyView() {
        this.wave = new Waves();
        this.drawFacade = new DrawFacade("koopaTroopa.png");
    }


    @Override
    public void render() {
        for (Enemy enemy: wave.getEnemiesToRender()) {
            float imgWidth = (float) Math.ceil(drawFacade.getTexture().getWidth()*0.25);
            float imgHeight = (float) Math.ceil(drawFacade.getTexture().getHeight()*0.15);
            enemy.moveEnemy();
            drawFacade.drawObject(enemy.getX(), enemy.getY(), imgWidth, imgHeight);
        }
    }
    @Override
    public void dispose() {
        drawFacade.dispose();
    }

    @Override
    public void updatePosition(float x, float y) {

    }
}
