package com.tda367.game;

import Controller.PlayerKeyListener;
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
	private PlayerKeyListener playerKeyListener;
	/**
	 * Initialises the model in the startup configuration, is called when the application starts
	 */
	@Override
	public void create () {
		//Handlers
		player = new Player(120,100, 50, 37);
		healthBar = new HealthBar(player.getPosX(), player.getPosY(), player.getHealth(), player.getWidth(), player.getHeight());
		tower = new Tower();
		worldBoundaries = new WorldBoundaries();
		enemy = EnemyFactory.createEnemy1();
		timer = GameTimer.GetInstance();
		fireAttack = new FireAttack(enemy.getX(), enemy.getY());
		//setup chain of responsibility?
		goldHandler = new Goldhandler();
		pointsHandler = new PointHandler();
		goldHandler.setSuccessor(pointsHandler);

		roundHandler = RoundHandler.GetInstance(timer);
		entityHolder = EntityHolder.getInstance();
		collisionDetection = CollisionDetection.getInstance();
		views = new ViewHolder(-0.5f,player, tower,worldBoundaries, healthBar, fireAttack);


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
