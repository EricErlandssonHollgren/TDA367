package View;

import Interfaces.IEnemyAttack;
import Interfaces.IView;
import Model.Facade.DrawFacade;

public class FireView implements IView {
    private IEnemyAttack fireAttack;
    private DrawFacade drawFacade;

    public FireView(IEnemyAttack fireAttack) {
        this.fireAttack = fireAttack;
        this.drawFacade = new DrawFacade("flame.png");
    }
    @Override
    public void render() {
        float imgPositionFromEnemy = 60;
        fireAttack.move();
        drawFacade.drawObject(fireAttack.getX()-imgPositionFromEnemy, fireAttack.getY(), fireAttack.getImgWidth(), fireAttack.getImgHeight());
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
