package View;

import Interfaces.IEnemy;
import Interfaces.IView;
import Model.Facade.DrawFacade;
import Model.GameTimer;
import Model.Waves;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Is in charge of rendering an enemy on the screen according to LibGDX implementation.
 */
public class EnemyView implements IView {

    private IEnemy enemy;

    private List<IEnemy> enemiesOnScreen;


    private Waves wave;
    private Texture img;

    private DrawFacade drawFacade;

    /**
     * A constructor for creating an Enemy.
     */
    public EnemyView(IEnemy enemy, String texturePath) {
        this.enemy = enemy;
        this.img = new Texture("koopaTroopa.png");
        this.wave = new Waves();
        this.enemiesOnScreen = new ArrayList<>();
        this.drawFacade = new DrawFacade(texturePath);
    }

    /**
     * A method for rendering, and moving, an enemy across the screen every 40 seconds.
     */
    @Override
    public void render() {
        if (Math.ceil(GameTimer.GetInstance().GetTime()) % 5 == 0) {
            enemiesOnScreen.add(wave.getEnemyFromQueue());
        }
       for (IEnemy enemy: enemiesOnScreen) {
            float imgWidth = (float) Math.ceil(img.getHeight()*0.15);
            float imgHeight = (float) Math.ceil(img.getWidth()*0.25);
            enemy.move();
            drawFacade.drawObject(enemy.getX(), enemy.getY(), imgWidth, imgHeight);
       }
    }
    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
