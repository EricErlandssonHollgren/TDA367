package Model;

import Controller.KeyListener;
import Interfaces.IView;
import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import View.EnemyView;
import View.PlayerView;
import View.ProjectileView;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.ArrayList;
import java.util.List;

public class ViewHolder {
    //
    private List<IView> views;
    private KeyListener keyListener;
    private World world;
    public ViewHolder(World world){
        //Instantiate world and views list
        this.world = world;
        views = new ArrayList<>();

        //Create views and objects
        IView projectileView = new ProjectileView(new Projectile(new Vector2(50,100), new Vector2(10,10), "badlogic.jpg"),this.world.getGravity());
        IView enemyView = new EnemyView(EnemyFactory.createEnemy1());
        PlayerView playerView = new PlayerView();
        Player player = new Player(10, 40,40,50);
        Ground ground = new Ground();


        keyListener = new KeyListener();
        keyListener.addSubscribers(player);
        player.positionSubscriber(playerView);
        createGround(world);

        //Add views to list and they will be rendered. Views must implement IView
        addView(enemyView);
        addView(playerView);
        addView(projectileView);
    }
    private void addView(IView view){
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


    public Body createGround(World world) {
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.type = BodyDef.BodyType.StaticBody;
        groundBodyDef.position.set(new Vector2(0.0f, 0.0f));
        Body bodyHej = world.createBody(groundBodyDef);
        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox(16.01f, 2.0f);
        bodyHej.createFixture(groundBox, 0.5f);
        groundBox.dispose();
        return bodyHej;
    }
}
