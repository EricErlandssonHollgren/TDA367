package com.tda367.game;

import Controller.PlayerKeyListener;
import Model.*;
import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import View.HealthBarView;
import View.PlayerView;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class App extends ApplicationAdapter {
	private SpriteBatch batch;
	private GameTimer timer;
	private ViewHolder views;
	private Player player;
	private EnemyFactory enemyFactory;
	private RoundHandler roundHandler;
	private MainHandler goldHandler;
	private MainHandler pointsHandler;
	private Tower tower;
	private WorldBoundaries worldBoundaries;
	private CollisionDetection collisionDetection;
	private EntityHolder entityHolder;
	private PlayerKeyListener playerKeyListener;
	/**
	 * Initialises the model in the startup configuration, is called when the application starts
	 */


	@Override
	public void create () {
		//Handlers
		tower = new Tower();
		worldBoundaries = new WorldBoundaries();
		timer = GameTimer.GetInstance();
		//setup chain of responsibility?
		goldHandler = new Goldhandler();
		pointsHandler = new PointHandler();
		goldHandler.setSuccessor(pointsHandler);
		roundHandler = RoundHandler.GetInstance(timer);

		entityHolder = EntityHolder.getInstance();
		collisionDetection = CollisionDetection.getInstance();

		PlayerView pV = new PlayerView();
		player = new Player(120,100, pV.playerSprite.getWidth(), pV.playerSprite.getHeight());


		views = new ViewHolder(-0.5f,player, tower,EnemyFactory.createEnemy1(),worldBoundaries);

		views.addView(new HealthBarView(player.healthBar));
		views.addView(pV);


		//Controllers
		playerKeyListener = new PlayerKeyListener();
		playerKeyListener.addSubscribers(player);

	}

	@Override
	public void render () {
		timer.UpdateTime(Gdx.graphics.getDeltaTime());
		collisionDetection.CheckCollisionPlayerAndEnemy(player);
		collisionDetection.CheckCollisionPlayerAndEnemy(player);
		collisionDetection.CheckCollisionPlayerNextStep(player);
		playerKeyListener.UpdatePlayerMovement();
		ScreenUtils.clear(0, 0, 0, 0);
		views.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		views.dispose();

	}
}
