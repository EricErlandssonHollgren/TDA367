package View;

import Interfaces.*;
import Model.Enemy.Enemy;
import Model.Facade.DrawFacade;
import Model.Waves;

/**
 * Is in charge of rendering an enemy on the screen according to LibGDX implementation.
 */
public class EnemyView implements IView, IEntitySubscriber{

    private Waves wave;
    private DrawFacade drawFacade;


    /**
     * A constructor for creating an Enemy.
     */
    public EnemyView() {
        this.wave = new Waves();
        this.drawFacade = new DrawFacade("koopaTroopa.png");
    }


    /**
     * Is responsible for rendering an enemy with the help of facade pattern.
     * Scaling of the texture is also being done in this method.
     */
    @Override
    public void render() {
        for (Enemy enemy: wave.getEnemiesToRender()) {
            float imgWidth = (float) Math.ceil(drawFacade.getTexture().getWidth()*0.15);
            float imgHeight = (float) Math.ceil(drawFacade.getTexture().getHeight()*0.10);
            enemy.moveEnemy();
            drawFacade.drawObject(enemy.getPosX(), enemy.getPosY(), imgWidth, imgHeight);
        }
    }
    @Override
    public void dispose() {

    }

    @Override
    public void updatePosition(float x, float y) {

    }

    @Override
    public void updateState() {
        drawFacade.dispose();
    }
}
