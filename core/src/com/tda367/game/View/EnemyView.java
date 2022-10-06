package View;

import Interfaces.IEnemy;
import Interfaces.IView;
import Model.Enemy.Enemies.Enemy1;
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
public class EnemyView implements IView {

    private IEnemy enemy;

    List<IEnemy> currentEnemiesRendered = new ArrayList<>();

    private Waves wave;
    private Texture img;

    private DrawFacade drawFacade;

    /**
     * A constructor for creating an Enemy.
     */
    public EnemyView(IEnemy enemy) {
        this.enemy = enemy;
        this.img = new Texture("koopaTroopa.png");
        this.wave = new Waves();
        this.drawFacade = new DrawFacade("koopaTroopa.png");
    }

    /**
     * A method for rendering, and moving, an enemy across the screen every 40 seconds.
     */

    public List<IEnemy> getEnemiesToRender() {
        double timer = GameTimer.GetInstance().GetTime();
        if (Math.ceil(timer) % 10 == 0) {
            IEnemy newEnemy = wave.getEnemyFromQueue();
            currentEnemiesRendered.add(newEnemy);
        }
        System.out.println(currentEnemiesRendered.size());
        return currentEnemiesRendered;
    }

    public void renderEnemy() {
        getEnemiesToRender();
        for (IEnemy enemy: currentEnemiesRendered) {
            float imgWidth = (float) Math.ceil(img.getWidth()*0.25);
            float imgHeight = (float) Math.ceil(img.getHeight()*0.15);
            enemy.move();
            drawFacade.drawObject(enemy.getX(), enemy.getY(), imgWidth, imgHeight);
        }
    }
    @Override
    public void render() {
        renderEnemy();
    }
    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
