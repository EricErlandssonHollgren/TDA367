package View;

import Interfaces.IProjectile;
import Interfaces.IView;
import Model.Facade.DrawFacade;

import java.util.ArrayList;
import java.util.List;

public class ProjectileView implements IView{
    private List<IProjectile> projectiles;
    private DrawFacade drawFacade;
    private ProjectileController controller;
    public ProjectileView(ProjectileController controller) {
        drawFacade = new DrawFacade("Cannonball.png");
        this.controller = controller;
    }
    @Override
    public void render() {
        for (IProjectile p: projectiles) {
            p.move();
            drawFacade.drawObject(p.getX(), p.getY(), 32, 32);
        }
    }
    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
