package View;

import Interfaces.IProjectile;
import Interfaces.IView;
import Model.Facade.DrawFacade;

import java.util.ArrayList;
import java.util.List;

public class ProjectileView implements IView{
    private List<IProjectile> projectiles;
    private DrawFacade drawFacade;

    public ProjectileView(String texturePath) {
        drawFacade = new DrawFacade(texturePath);
        projectiles = new ArrayList<>();
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
