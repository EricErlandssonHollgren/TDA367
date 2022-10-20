package View;

import Interfaces.*;
import Model.*;
import Model.Facade.DrawFacade;

import java.util.List;

/**
 * Is in charge of rendering an enemy on the screen according to LibGDX implementation.
 */
public class EnemyView implements IView{

    private DrawFacade drawFacade;
    /**
     * A constructor for creating an Enemy.
     */
    public EnemyView() {
        this.drawFacade = new DrawFacade();
        drawFacade.setTexture("koopaTroopa.png");
    }


    /**
     * Is responsible for rendering an enemy with the help of facade pattern.
     * Scaling of the texture is also being done in this method.
     */
    @Override
    public void render() {
        for (Entity enemy: EntityHolder.getInstance().getEntities()) {
            if(enemy instanceof Enemy){
                ((Enemy) enemy).moveEnemy();
                drawFacade.drawObject(enemy.getPosX(), enemy.getPosY(), enemy.getWidth(), enemy.getHeight());
            }
        }
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
