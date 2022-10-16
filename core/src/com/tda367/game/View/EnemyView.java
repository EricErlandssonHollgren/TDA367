package View;

import Interfaces.*;
import Model.AttackFactory;
import Model.Enemy;
import Model.Facade.DrawFacade;
import Model.FireAttack;
import Model.Waves;

import java.util.List;

/**
 * Is in charge of rendering an enemy on the screen according to LibGDX implementation.
 */
public class EnemyView implements IView, IEntitySubscriber{

    private Enemy enemy;
    private DrawFacade drawFacade;

    private FireView fireView;
    /**
     * A constructor for creating an Enemy.
     */
    public EnemyView() {
        this.drawFacade = new DrawFacade("koopaTroopa.png");
        this.fireView = new FireView(AttackFactory.createFireFlame());
        this.enemy = new Enemy(630,100,10, AttackFactory.createFireFlame()) ;
    }


    /**
     * Is responsible for rendering an enemy with the help of facade pattern.
     * Scaling of the texture is also being done in this method.
     */
    @Override
    public void render() {
        enemy.move();
        drawFacade.drawObject(enemy.getPosX(), enemy.getPosY(), enemy.getWidth(), enemy.getHeight());
        fireView.render();
    }
    @Override
    public void dispose() {
        drawFacade.dispose();
        fireView.dispose();
    }

    @Override
    public void updatePosition(float x, float y) {

    }

    @Override
    public void updateState() {

    }
}
