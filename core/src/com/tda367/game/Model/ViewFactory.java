package Model;

import Interfaces.IProjectile;
import Interfaces.IView;
import View.ProjectileView;
import com.badlogic.gdx.math.Vector2;

public class ViewFactory {
    public static IView createProjectileView(IProjectile p){
        return new ProjectileView(p);
    }
}
