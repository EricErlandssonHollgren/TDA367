package View;

import Interfaces.IView;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import Model.Facade.DrawFacade;
import Model.FireFlame;
import Model.Waves;

public class FireView implements IView {
    Enemy enemy;

    Waves wave;
    FireFlame fireFlame;
    DrawFacade drawFacade;

    public FireView(FireFlame fireFlame) {
        this.fireFlame = fireFlame;
        this.wave = new Waves();
        this.enemy = EnemyFactory.createEnemy1();
        this.drawFacade = new DrawFacade("flame.png");
    }
    @Override
    public void render() {
        float positionFromEnemy = 60;
        float imgWidth = 70;
        float imgHeight = 70;
        for (Enemy enemy: wave.getEnemiesToRender()) {
            drawFacade.drawObject(enemy.getX()-positionFromEnemy, enemy.getY(), imgWidth,imgHeight);
            fireFlame.updatePosition(enemy.getUpdatedPosition(), enemy.getPosY());
        }
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
