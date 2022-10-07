package Model;

import Interfaces.IPlayerSubscriber;
import Interfaces.IView;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import Controller.KeyListener;
import View.*;
import View.EnemyView;
import View.HealthBarView;
import View.PlayerView;
import View.ProjectileView;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

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
    public ViewHolder(float gravity, Player player, Tower tower, Enemy enemy, WorldBoundaries worldBoundaries){
        //Instantiate world and views list
        this.gravity = gravity;
        views = new ArrayList<>();

        //Create views and objects
        IView enemyView = new EnemyView(EnemyFactory.createEnemy1());
        PlayerView playerView = new PlayerView();
        Player player = new Player(40f, 50f, playerView.playerSprite.getWidth(), playerView.playerSprite.getHeight());
        IView healhBarView = new HealthBarView(player.healthBar);

        IView worldBoundariesView = new WorldBoundariesView(worldBoundaries);
        IView enemyView = ViewFactory.createEnemyView();
        IView playerView = new PlayerView();
        IView towerView = new TowerView(tower);
        IView background = new BackgroundView();
        player.positionSubscriber((IPlayerSubscriber) playerView);
        //Add views to list and they will be rendered. Views must implement IView
        addView(background);
        addView(worldBoundariesView);
        addView(playerView);
        addView(healhBarView);
        addView(towerView);
        addView(enemyView);
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
