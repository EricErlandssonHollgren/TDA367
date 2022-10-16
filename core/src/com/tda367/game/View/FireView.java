package View;

import Interfaces.IEnemyAttack;
import Interfaces.IView;
import Model.Enemy;
import Model.Entity;
import Model.EntityHolder;
import Model.Facade.DrawFacade;
import Model.Waves;

import java.util.List;

public class FireView implements IView {

    private List<Entity> enemies;
    private DrawFacade drawFacade;

    public FireView() {
        this.enemies = EntityHolder.getInstance().getEntities();
        this.drawFacade = new DrawFacade("flame.png");
    }

    @Override
    public void render() {
        float imgPositionFromEnemy = 60;
        for (Entity enemy: enemies) {
            drawFacade.drawObject(enemy.getPosX()-imgPositionFromEnemy, enemy.getPosY(), enemy.getWidth(), enemy.getHeight());
        }
    }


    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
