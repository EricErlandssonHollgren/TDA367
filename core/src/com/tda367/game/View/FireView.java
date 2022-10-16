package View;

import Interfaces.IEnemyAttack;
import Interfaces.IView;
import Model.Enemy;
import Model.Entity;
import Model.EntityHolder;
import Model.Facade.DrawFacade;
import Model.Waves;

public class FireView implements IView {

    private Waves wave;
    private DrawFacade drawFacade;

    public FireView() {
        this.wave = new Waves();
        this.drawFacade = new DrawFacade("flame.png");
    }
    @Override
    public void render() {
        float imgPositionFromEnemy = 60;
        for (Entity enemy: EntityHolder.getInstance().getEntities()) {
            if(enemy instanceof Enemy){
                ((Enemy) enemy).moveEnemy();
                drawFacade.drawObject(enemy.getPosX()-imgPositionFromEnemy, enemy.getPosY(), enemy.getWidth(), enemy.getHeight());
            }
        }
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
