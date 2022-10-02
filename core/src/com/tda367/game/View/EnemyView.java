package View;

import Interfaces.IEnemy;
import Interfaces.IView;
import Model.GameTimer;
import Model.Waves;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Is in charge of rendering an enemy on the screen according to LibGDX implementation.
 */
public class EnemyView implements IView {

    private IEnemy enemy;

    private SpriteBatch batch;

    private Waves wave;
    private Texture img;

    /**
     * A constructor for creating an Enemy.
     */
    public EnemyView(IEnemy enemy) {
        this.enemy = enemy;
        batch = new SpriteBatch();
        img = new Texture("koopaTroopa.png");
        wave = new Waves();
    }

    /**
     * A method for rendering, and moving, an enemy across the screen every 40 seconds.
     */
    @Override
    public void render() {
        float positionX = enemy.getX().x;
        float positionY = enemy.getY().y;
        batch.begin();
        batch.draw(img, positionX, positionY, (float) Math.ceil(img.getHeight()*0.15), (float) Math.ceil(img.getWidth()*0.25));
        if (Math.ceil(GameTimer.GetInstance().GetTime()) % 40 == 0) {
            enemy = wave.getEnemyFromQueue();
        }
        enemy.move();
        batch.end();
    }
    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
