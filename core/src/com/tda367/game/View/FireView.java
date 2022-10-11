package View;

import Interfaces.IView;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import Model.Facade.DrawFacade;

public class FireView implements IView {
    Enemy enemy;
    DrawFacade drawFacade;

    public FireView() {
        this.enemy = EnemyFactory.createEnemy1();
        this.drawFacade = new DrawFacade("flame.png");
    }
    @Override
    public void render() {

    }

    @Override
    public void dispose() {

    }
}
