package com.tda367.game;

import Controller.PlayerListener;
import Interfaces.IEntitySubscriber;
import Interfaces.IView;
import Model.*;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import View.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class App extends ApplicationAdapter {
	private SpriteBatch batch;
	private GameTimer timer;
	private ViewHolder views;
	private Player player;
	private Enemy enemy;
	private RoundHandler roundHandler;
	private MainHandler goldHandler;
	private MainHandler pointsHandler;
	private Tower tower;
	private HealthBar healthBar;

	private FireAttack fireAttack;
	private WorldBoundaries worldBoundaries;
	private CollisionDetection collisionDetection;
	private EntityHolder entityHolder;
	private PlayerListener playerListener;
	/**
	 * Initialises the model in the startup configuration, is called when the application starts
	 */
	@Override
	public void create () {
		//Model
		player = new Player(120,100, 50, 37);
		healthBar = new HealthBar(player.getPosX(), player.getPosY(), player.getHealth(), player.getWidth(), player.getHeight());
		tower = new Tower();
		worldBoundaries = new WorldBoundaries();
		timer = GameTimer.GetInstance();
		enemy = EnemyFactory.createEnemy1();

		//Handlers
		goldHandler = new Goldhandler();
		pointsHandler = new PointHandler();
		goldHandler.setSuccessor(pointsHandler);
		roundHandler = RoundHandler.GetInstance(timer);
		entityHolder = EntityHolder.getInstance();
		collisionDetection = CollisionDetection.getInstance();

		//Controllers
		playerListener = new PlayerListener();
		playerListener.addSubscribers(player);

		//Create views and objects
		IView worldBoundariesView = new WorldBoundariesView(worldBoundaries);
		IView enemyView = ViewFactory.createEnemyView();
		IView playerView = new PlayerView();
		IView towerView = new TowerView(tower);
		IView healthBarView = new HealthBarView(player.healthBar);
		IView fireView = new FireView(enemy.enemyAttack);
		IView statsView = new StatsView();
		IView background = new BackgroundView();
		player.positionSubscriber((IEntitySubscriber) playerView);

		//Add views to list and they will be rendered. Views must implement IView
		views = new ViewHolder();
		views.addView(background);
		views.addView(worldBoundariesView);
		views.addView(playerView);
		views.addView(towerView);
		views.addView(fireView);
		views.addView(enemyView);
		views.addView(statsView);
		views.addView(healthBarView);

	}
  
	@Override
	public void render () {
		timer.UpdateTime(Gdx.graphics.getDeltaTime());
		collisionDetection.CheckCollisionPlayerAndEnemy(player);
		//collisionDetection.CheckCollisionPlayerAndEnemy(player);
		collisionDetection.CheckCollisionPlayerNextStep(player);
		collisionDetection.CheckCollisionEnemyAndHitBox(player);
		playerListener.UpdatePlayerMovement();
		playerListener.UpdatePlayerState();
		ScreenUtils.clear(0, 0, 0, 0);
		views.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		views.dispose();

	}
}
