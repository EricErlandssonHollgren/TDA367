package View;

import Interfaces.IProjectile;
import Interfaces.IView;
import Model.Facade.DrawFacade;

public class ProjectileView implements IView{
    private IProjectile projectile;
    private DrawFacade drawFacade;

    public ProjectileView(IProjectile projectile) {
        drawFacade = new DrawFacade(projectile.getTexturePath());
        this.projectile = projectile;
    }

    @Override
    public void render() {
        projectile.move();
        drawFacade.drawObject(projectile.getX(), projectile.getY(), 32, 32);
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }

}
