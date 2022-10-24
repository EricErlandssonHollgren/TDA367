package View;

import Interfaces.IView;

import java.util.ArrayList;
import java.util.List;

public class ViewHolder {

    private List<IView> views;

    /**
     * Initiates a holder for the views and calls the views to render
     */
    public ViewHolder(){
        views = new ArrayList<>();
    }

    /**
     * Adds a View to ViewHolders views to be rendered.
     */
    public void addView(IView view){
        views.add(view);
    }

    public void removeAllViews() {views = new ArrayList<>();}

    /**
     * Renders the views in ViewHolders list.
     */
    public void render(){
        for (IView views: views) {
            views.render();
        }
    }

    /**
     * Disposes the views in ViewHolders list.
     */
    public void dispose(){
        for (IView views: views) {
            views.dispose();
        }
    }
}
