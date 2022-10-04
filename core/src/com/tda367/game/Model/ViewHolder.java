package Model;

import Controller.KeyListener;
import Interfaces.IProjectile;
import Interfaces.IView;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import View.*;

import java.util.ArrayList;
import java.util.List;

public class ViewHolder {
    //
    private List<IView> views;
    private KeyListener keyListener;
    private float gravity;
    private CollisionDetection cd;
    public ViewHolder(float gravity){
        //Instantiate world and views list
        this.gravity = gravity;
        views = new ArrayList<>();

        //Create views and objects
        IView enemyView = new EnemyView(EnemyFactory.createEnemy1());

        Enemy enemy = EnemyFactory.createEnemy1();
        IView worldBoundariesView = new WorldBoundariesView();
        PlayerView playerView = new PlayerView();
        Player player = new Player(9, 100);
        Tower tower = new Tower();
        TowerView towerView = new TowerView(tower);

        keyListener = new KeyListener();
        keyListener.addSubscribers(player);
        keyListener.addSubscribers(tower);
        cd = CollisionDetection.getInstance(player);

        IProjectile p = ProjectileFactory.createCannonball(0,200,10,0,0,10);
        IView pv = ViewFactory.createProjectileView(p);

        keyListener = new KeyListener();
        keyListener.addSubscribers(player);
        player.positionSubscriber(playerView);
        EntityHolder.getInstance().addEntity(enemy);
        //Add views to list and they will be rendered. Views must implement IView
        addView(worldBoundariesView);
        addView(enemyView);
        addView(playerView);
        addView(pv);
    }
    public void addView(IView view){
        views.add(view);
    }
    public void removeView(IView view){
        views.remove(view);
    }
    public void render(){
        keyListener.UpdatePlayerMovement();
        cd.CheckCollisionPlayerAndEnemy();
        cd.CheckCollisionPlayerNextStep();
        cd.checkCollisionProjectileAndEnemy();
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
