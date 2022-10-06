package Model;

import Interfaces.IPlayerSubscriber;
import Interfaces.IView;
import View.*;

import java.util.ArrayList;
import java.util.List;

public class ViewHolder {
    //
    private List<IView> views;
    //private PlayerKeyListener keyListener;
    private float gravity;

    /**
     * Initialises the startup views
     * @param gravity
     */
    public ViewHolder(float gravity){
        //Instantiate world and views list
        this.gravity = gravity;
        views = new ArrayList<>();

    }
    public void addView(IView view){
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
