package View;

import Interfaces.IEnemyAttack;
import Interfaces.IView;
import Model.*;
import Model.Facade.DrawFacade;

import java.util.List;

public class FireView implements IView {

    private List<Entity> enemies;
    private DrawFacade drawFacade;

    public FireView() {
        this.enemies = EntityHolder.getInstance().getEntities();
        this.drawFacade = new DrawFacade();
        drawFacade.setTexture("flame.png");
    }

    @Override
    public void render() {
        float imgPositionFromEnemy = 60;
        for (Entity enemy: enemies) {
            if(enemy instanceof Enemy){
                IEnemyAttack attack = ((Enemy) enemy).getEnemyAttack();
                drawFacade.drawObject(attack.getX()-imgPositionFromEnemy, attack.getY(), attack.getWidth(), enemy.getHeight());
            }
        }
    }


    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
