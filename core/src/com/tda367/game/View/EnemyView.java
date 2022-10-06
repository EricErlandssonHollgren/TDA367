package View;

import Interfaces.*;
import Model.Facade.DrawFacade;
import Model.GameTimer;
import Model.Waves;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Is in charge of rendering an enemy on the screen according to LibGDX implementation.
 */
public class EnemyView implements IView{
    private List<IEntity> enemiesOnScreen;
    private Waves wave;
    private Texture img;
    private DrawFacade drawFacade;
    private Sprite enemySprite;

    /**
     * A constructor for creating an Enemy.
     */
    public EnemyView() {
        wave = new Waves();
        enemiesOnScreen = new ArrayList<>();
        drawFacade = new DrawFacade("koopaTroopa.png");
        enemySprite = new Sprite();

    }

    /**
     * A method for rendering, and moving, an enemy across the screen every 40 seconds.
     */
    @Override
    public void render() {
        if (Math.ceil(GameTimer.GetInstance().GetTime()) % 5 == 0) {
            enemiesOnScreen.add(wave.getEnemyFromQueue());
        }
        for (IEntity e:enemiesOnScreen) {
            drawFacade.drawObject(e.getX(), e.getY(), 64,64);
        }

    }
    @Override
    public void dispose() {
        drawFacade.dispose();
    }

}
