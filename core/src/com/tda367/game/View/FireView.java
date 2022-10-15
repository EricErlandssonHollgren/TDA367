package View;

import Interfaces.IEnemyAttack;
import Interfaces.IProjectile;
import Interfaces.IView;
import Model.Enemy.Enemy;
import Model.Entity;
import Model.Facade.DrawFacade;
import Model.Waves;

public class FireView implements IView {
    private IEnemyAttack fireAttack;

    private Waves wave;
    private DrawFacade drawFacade;

    public FireView(IEnemyAttack fireAttack) {
        this.fireAttack = fireAttack;
        this.wave = new Waves();
        this.drawFacade = new DrawFacade("flame.png");
    }
    @Override
    public void render() {
        float imgPositionFromEnemy = 50;
        for (Entity enemy: wave.getEnemiesToRender()) {
            if(enemy instanceof Enemy) {
                ((Enemy) enemy).moveEnemy();
                drawFacade.drawObject(enemy.getPosX() - imgPositionFromEnemy, enemy.getPosY(), fireAttack.getImgWidth(), fireAttack.getImgHeight());
            }
        }
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
