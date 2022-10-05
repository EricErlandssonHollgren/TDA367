package Model;

import Interfaces.IEnemy;
import Interfaces.IView;
import View.EnemyView;
import Interfaces.IProjectile;
import View.ProjectileView;


/**
 * A factory class with the sole purpose of handling the creation of different views, ex. enemies.
 */
public class ViewFactory {
    public static IView createEnemyView(IEnemy e) {
        return new EnemyView(e, "koopaTroopa.png");
    }
    public static IView createProjectileView(IProjectile p){
        return new ProjectileView(p, "Cannonball.png");
    }
}