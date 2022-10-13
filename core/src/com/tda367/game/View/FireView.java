package View;

import Interfaces.IView;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import Model.Facade.DrawFacade;
import Model.FireAttack;

public class FireView implements IView {
    Enemy enemy;
    FireAttack fireAttack;
    DrawFacade drawFacade;

    public FireView() {
        this.fireAttack = new FireAttack(630,100);
        this.enemy = EnemyFactory.createEnemy1();
        this.drawFacade = new DrawFacade("flame.png");
    }
    @Override
    public void render() {
        float imgPositionFromEnemy = 60;
        drawFacade.drawObject(enemy.getPosX()-imgPositionFromEnemy, enemy.getPosY(), fireAttack.getImgWidth(), fireAttack.getImgHeight());
        fireAttack.updatePosition(enemy.getUpdatedPosition(), enemy.getPosY());
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
