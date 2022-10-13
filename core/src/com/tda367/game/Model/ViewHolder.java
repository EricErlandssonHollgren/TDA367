package Model;

import Interfaces.IEntitySubscriber;
import Interfaces.IView;
import View.*;

import java.util.ArrayList;
import java.util.List;

public class ViewHolder {
    //
    private List<IView> views;

    /**
     * Initiates a holder for the views and calls the views to render
     */
    public ViewHolder(){
        //Instantiate world and views list
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
