package com.tda367.game;

import Controller.PlayerKeyListener;
import Controller.TowerController;
import Model.*;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class App extends ApplicationAdapter {
	private SpriteBatch batch;
	private GameTimer timer;
	private ViewHolder views;
	private Player player;
	private HealthBar healthBar;
	private RoundHandler roundHandler;
	private MainHandler goldHandler;
	private MainHandler pointsHandler;
	private Tower tower;
	private WorldBoundaries worldBoundaries;
	private CollisionDetection collisionDetection;
	private EntityHolder entityHolder;
	private PlayerKeyListener playerKeyListener;
	private TowerController towerController;
	/**
	 * Initialises the model in the startup configuration, is called when the application starts
	 */
	@Override
	public void create () {
		//Handlers


		healthBar = new HealthBar(120, 120, 10, 50, 50);
		player = new Player(120,100, 50, 37);
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

		views = new ViewHolder(-0.5f,player,tower,worldBoundaries, healthBar);

		//Controllers
		playerKeyListener = new PlayerKeyListener();
		playerKeyListener.addSubscribers(player);
		towerController = new TowerController();
		towerController.addSubscribers(tower);
	}
  
	@Override
	public void render () {
		timer.UpdateTime(Gdx.graphics.getDeltaTime());
		collisionDetection.CheckCollisionPlayerAndEnemy(player);
		collisionDetection.CheckCollisionPlayerAndEnemy(player);
		collisionDetection.CheckCollisionPlayerNextStep(player);
		playerKeyListener.UpdatePlayerMovement();
		views.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		views.dispose();

	}
}
