package View;

import Interfaces.IEnemyAttack;
import Interfaces.IView;
import Model.*;
import Model.Facade.DrawFacade;

import java.util.List;

public class FireView implements IView {

    private List<Entity> enemies;
    private DrawFacade drawFacade;

    private FireAttack fireAttack;

    public FireView() {
        this.enemies = EntityHolder.getInstance().getEntities();
        this.drawFacade = new DrawFacade("flame.png");
        this.fireAttack = new FireAttack(630,100);
    }

    @Override
    public void render() {
        float imgPositionFromEnemy = 60;
        for (Entity enemy: enemies) {
            fireAttack.move();
            drawFacade.drawObject(enemy.getPosX()-imgPositionFromEnemy, enemy.getPosY(), enemy.getWidth(), enemy.getHeight());
        }
    }


    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
