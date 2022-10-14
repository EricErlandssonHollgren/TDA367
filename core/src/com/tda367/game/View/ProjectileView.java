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
    public ProjectileView(String texturePath, ProjectileController controller) {
        drawFacade = new DrawFacade(texturePath);
        this.controller = controller;
    }
    @Override
    public void render() {
        for (IProjectile p: controller.getCurrentProjectiles()) {
            p.move();
            drawFacade.drawObject(p.getX(), p.getY(), 32, 32);
        }
    }
    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
