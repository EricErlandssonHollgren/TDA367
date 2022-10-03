package Model;

import Controller.KeyListener;
import Interfaces.IView;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import View.EnemyView;
import View.PlayerView;
import View.WorldBoundariesView;

import java.util.ArrayList;
import java.util.List;

public class ViewHolder {
    //
    private List<IView> views;
    private KeyListener keyListener;
    private float gravity;
    public ViewHolder(float gravity){
        //Instantiate world and views list
        this.gravity = gravity;
        views = new ArrayList<>();

        //Create views and objects
        IView enemyView = new EnemyView(EnemyFactory.createEnemy1());
        IView projectileView = ViewFactory.createProjectileView(ProjectileFactory.createCannonball(50,200,3,10,gravity));
        IView projectileView2 = ViewFactory.createProjectileView(ProjectileFactory.createCannonball(25,200,6,10,gravity));
        IView projectileView3 = ViewFactory.createProjectileView(ProjectileFactory.createCannonball(70,200,3,19,gravity));
        Enemy enemy = EnemyFactory.createEnemy1();
        IView enemyView = new EnemyView(enemy);
        IView worldBoundariesView = new WorldBoundariesView();
        PlayerView playerView = new PlayerView();
        Player player = new Player(9, 100);
        Tower tower = new Tower();
        TowerView towerView = new TowerView(tower);

        keyListener = new KeyListener();
        keyListener.addSubscribers(player);
        keyListener.addSubscribers(tower);
        Player player = new Player(10, 100);
        cd = CollisionDetection.getInstance(player);

        keyListener = new KeyListener();
        keyListener.addSubscribers(player);
        player.positionSubscriber(playerView);
        EntityHolder.getInstance().addEntity(enemy);
        //Add views to list and they will be rendered. Views must implement IView
        addView(worldBoundariesView);
        addView(enemyView);
        addView(playerView);
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
        cd.CheckCollisionPlayerAndBoundaries();
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
