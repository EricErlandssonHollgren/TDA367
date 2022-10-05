package Model;

import Controller.*;
import Interfaces.IView;
import Model.Enemy.EnemyFactory;
import View.EnemyView;
import View.PlayerView;
import View.TowerView;

import java.util.ArrayList;
import java.util.List;

public class ViewHolder {
    //
    private List<IView> views;
    private PlayerKeyListener playerKeyListener;
    private UpgradeKeyListener upgradeKeyListener;
    private float gravity;
    public ViewHolder(float gravity){
        //Instantiate world and views list
        this.gravity = gravity;
        views = new ArrayList<>();

        //Create views and objects
        IView enemyView = new EnemyView(EnemyFactory.createEnemy1());
        PlayerView playerView = new PlayerView();
        Player player = new Player(9, 100);
        Tower tower = new Tower();
        TowerView towerView = new TowerView(tower);

        upgradeKeyListener = new UpgradeKeyListener();
        upgradeKeyListener.addSubscribers(tower);

        playerKeyListener = new PlayerKeyListener();
        playerKeyListener.addSubscribers(player);
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
        playerKeyListener.UpdatePlayerMovement();
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
