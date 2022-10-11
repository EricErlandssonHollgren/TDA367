package Model;

import Interfaces.IEntitySubscriber;
import Interfaces.IView;
import Model.Enemy.Enemy;
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
    public ViewHolder(float gravity, Player player, Tower tower, WorldBoundaries worldBoundaries, HealthBar healthBar, FireFlame fireFlame){
        //Instantiate world and views list
        this.gravity = gravity;
        views = new ArrayList<>();

        //Create views and objects
        IView worldBoundariesView = new WorldBoundariesView(worldBoundaries);
        IView enemyView = ViewFactory.createEnemyView();
        IView playerView = new PlayerView();
        IView towerView = new TowerView(tower);
        IView statsView = new StatsView();
        IView healthBarView = new HealthBarView(player.healthBar);
        IView fireView = new FireView(fireFlame);
        IView background = new BackgroundView();
        player.positionSubscriber((IEntitySubscriber) playerView);
        //Add views to list and they will be rendered. Views must implement IView
        addView(background);
        addView(statsView);
        addView(worldBoundariesView);
        addView(playerView);
        addView(towerView);
        addView(enemyView);
        addView(healthBarView);
        addView(fireView);
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
