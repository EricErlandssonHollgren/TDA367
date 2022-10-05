package Model;

import Interfaces.IProjectile;
import Interfaces.IView;
import View.ProjectileView;

public class ViewFactory {
    public static IView createProjectileView(IProjectile p){
        return new ProjectileView("Cannonball.png");
    }
}
