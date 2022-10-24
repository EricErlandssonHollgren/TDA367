package View;

import Model.ProjectileHandler;
import Interfaces.IProjectile;
import Interfaces.IView;
import View.Facade.DrawFacade;

public class ProjectileView implements IView{

    private DrawFacade drawFacade;
    private ProjectileHandler handler;

    /**
     * Constructor for projectile view
     * @param handler reference to the projectile handler
     */
    public ProjectileView(ProjectileHandler handler) {
        this.handler = handler;
        this.drawFacade = new DrawFacade();
    }
    @Override
    public void render() {
        for (IProjectile p: handler.getCurrentProjectiles()) {
            p.move();
            drawFacade.setTexture(p.getTexturePath());
            drawFacade.drawObject(p.getX(), p.getY(), 32, 32);
        }
    }
    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
