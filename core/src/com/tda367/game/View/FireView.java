package View;

import Interfaces.IProjectile;
import Interfaces.IView;
import Model.Facade.DrawFacade;

public class FireView implements IView {
    private IProjectile fireAttack;
    private DrawFacade drawFacade;

    public FireView(IProjectile fireAttack) {
        this.fireAttack = fireAttack;
        this.drawFacade = new DrawFacade("flame.png");
    }
    @Override
    public void render() {
        float imgPositionFromEnemy = 50;
        fireAttack.move();
        drawFacade.drawObject(fireAttack.getX()-imgPositionFromEnemy, fireAttack.getY(), fireAttack.getRadius(), fireAttack.getRadius());
        //System.out.println(fireAttack.getX());
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
