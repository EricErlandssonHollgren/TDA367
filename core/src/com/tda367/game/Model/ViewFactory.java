package Model;

import Interfaces.IView;
import View.EnemyView;
import Interfaces.IProjectile;
import View.ProjectileView;


/**
 * A factory class with the sole purpose of handling the creation of different views, ex. enemies.
 */
public class ViewFactory {
    public static IView createEnemyView() {
        return new EnemyView();
    }
    /*public static IView createProjectileView(IProjectile p){
        return new ProjectileView("Cannonball.png");
    }

     */
}