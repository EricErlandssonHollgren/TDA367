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
        //drawFacade.drawObject(wave.getEnemyFromQueue().getX(), wave.getEnemyFromQueue().getY(), 50, 50);
        //fireFlame.updatePosition(wave.getEnemyFromQueue().getUpdatedPosition(), wave.getEnemyFromQueue().getY());
        drawFacade.drawObject(enemy.getX(), enemy.getY()+30, 50,50);
        fireFlame.updatePosition(enemy.getUpdatedPosition(), enemy.getPosY());
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
