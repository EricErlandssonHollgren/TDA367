package View;

import Controller.ProjectileController;
import Interfaces.IProjectile;
import Interfaces.IView;
import Model.Entity;
import Model.EntityHolder;
import Model.Facade.DrawFacade;

import java.util.ArrayList;
import java.util.List;

public class ProjectileView implements IView{

    private DrawFacade drawFacade;
    private ProjectileController controller;
    public ProjectileView(ProjectileController controller) {
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
