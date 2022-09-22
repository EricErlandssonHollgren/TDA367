package Model;

import Interfaces.IView;
import View.ProjectileView;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class ViewHolder {
    private List<IView> views;
    public ViewHolder(){
        views = new ArrayList<>();
        IView projectileView = new ProjectileView(new Projectile(new Vector2(50,100), new Vector2(10,10), "badlogic.jpg"),world.getGravity());
        addView(projectileView);
    }
    private void addView(IView view){
        views.add(view);
    }
    public void removeView(IView view){
        views.remove(view);
    }
    public void render(){
        for (IView views: views) {
            views.render();
        }
    }
    public void dispose(){
        for (IView views: views) {
            views.dispose();
        }
    }
}
