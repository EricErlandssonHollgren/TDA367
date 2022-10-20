package View;

import Model.ProjectileHandler;
import Interfaces.IProjectile;
import Interfaces.IView;
import Model.Facade.DrawFacade;

public class ProjectileView implements IView{

    private DrawFacade drawFacade;
    private ProjectileHandler controller;
    public ProjectileView(ProjectileHandler controller) {
        this.controller = controller;
        this.drawFacade = new DrawFacade();
    }
    @Override
    public void render() {
        for (IProjectile p: controller.getCurrentProjectiles()) {
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
