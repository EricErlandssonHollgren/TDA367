package Model;

import Controller.KeyListener;
import Interfaces.IEnemy;
import Interfaces.IView;
import Model.Enemy.EnemyFactory;
import View.EnemyView;
import View.PlayerView;
import View.ProjectileView;
import View.TowerView;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

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
        IView enemyView = new EnemyView(EnemyFactory.createEnemy1(), "koopaTroopa.png");
        //IView enemyViewTest = ViewFactory.createEnemyView(EnemyFactory.createEnemy1());
        PlayerView playerView = new PlayerView();
        Player player = new Player(9, 100);
        Tower tower = new Tower();
        TowerView towerView = new TowerView(tower);

        keyListener = new KeyListener();
        keyListener.addSubscribers(player);
        keyListener.addSubscribers(tower);

        keyListener = new KeyListener();
        keyListener.addSubscribers(player);
        player.positionSubscriber(playerView);

        //Add views to list and they will be rendered. Views must implement IView
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
