package game;

import Controller.KeyListener;
import Interfaces.IView;
import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import Model.Player;
import View.PlayerView;
import Interfaces.IView;
import Model.GameTimer;
import Model.Projectile;
import Model.ViewHolder;
import View.ProjectileView;
import Interfaces.IView;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import View.EnemyView;

import java.util.ArrayList;
import java.util.List;

public class App extends ApplicationAdapter {

	List<IView> views;
	SpriteBatch batch;
	KeyListener keyListener;

	Enemy enemy = new Enemy1();
	Texture img;
	World world;
	GameTimer timer;
	ViewHolder views;
	@Override
	public void create () {
		views = new ViewHolder();
		world = new World(new Vector2(0,-0.5f),true);
		batch = new SpriteBatch();
		Player player = new Player(40f, 50f);
		keyListener = new KeyListener();
		PlayerView playerView = new PlayerView();

		keyListener.addSubscribers(player);
		player.positionSubscriber(playerView);
		views.add(playerView);
		timer = GameTimer.GetInstance();
		img = new Texture("badlogic.jpg");
		//TODO

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		views.render();
		keyListener.UpdatePlayerPosition();
		for (int i = 0; i <=views.size()-1; i++) {
			views.get(i).render();

		}
		batch.end();
		for (int i = 0; i <= views.size()-1; i++) {
			views.get(i).render();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		views.dispose();
	}
}
