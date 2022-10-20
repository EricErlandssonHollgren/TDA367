package com.tda367.game;

import Controller.PlayerSpawnController;
import Model.ProjectileHandler;
import Controller.TowerController;
import Interfaces.IProjectile;
import Interfaces.IView;
import Controller.PlayerController;
import Model.*;
import View.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.List;
import java.util.Map;

public class App extends ApplicationAdapter {
	private SpriteBatch batch;
	private GameTimer timer;
	private ViewHolder views;
	private Player player;
	private RoundHandler roundHandler;
	private MainHandler goldHandler;
	private MainHandler pointsHandler;
	private Tower tower;
	private Waves wave;
	private HealthBar healthBar;
	private WorldBoundaries worldBoundaries;
	private CollisionDetection collisionDetection;
	private EntityHolder entityHolder;
	private TowerController towerController;
	private PlayerController playerController;
	private PlayerSpawnController playerSpawnController;
	private ProjectileHandler projectileHandler;

	/**
	 * Initialises the model in the startup configuration, is called when the application starts
	 */
	@Override
	public void create () {
		//Objects
		player = new Player(120,100, 50, 37, 125);
		healthBar = new HealthBar(player.getPosX(), player.getPosY(), player.getHealth(), player.getWidth(), player.getHeight());
		worldBoundaries = new WorldBoundaries();
		timer = GameTimer.GetInstance();
		wave = new Waves();

		//Handlers
		goldHandler = new Goldhandler();
		pointsHandler = new PointHandler();
		goldHandler.setSuccessor(pointsHandler);


		//Instantiates Tower, (needs to be done after instantiating Goldhandler).
		tower = new Tower((Goldhandler) goldHandler);

		entityHolder = EntityHolder.getInstance();
		collisionDetection = CollisionDetection.getInstance();

		//Controllers
		towerController = new TowerController();
		towerController.addSubscribers(tower);
		playerController = new PlayerController();
		playerController.addSubscribers(player);
		playerSpawnController = new PlayerSpawnController();
		towerController = new TowerController();
		towerController.addSubscribers(tower);
		projectileHandler = new ProjectileHandler(entityHolder,collisionDetection,timer);

		//Create views and objects
		IView worldBoundariesView = new WorldBoundariesView(worldBoundaries);
		IView wavesView = new WavesView(wave);
		IView playerView = new PlayerView(player);
		IView towerView = new TowerView(tower);
		IView buttonView = new ButtonView(towerController, tower, playerSpawnController, player);
		IView healthBarView = new HealthBarView(player.healthBar);
		IView statsView = new StatsView();
		IView background = new BackgroundView();
		IView projectileView = new ProjectileView(projectileHandler);

		//Add views to list and they will be rendered. Views must implement IView
		views = new ViewHolder();
		views.addView(background);
		views.addView(worldBoundariesView);
		views.addView(statsView);
		views.addView(playerView);
		views.addView(towerView);
		views.addView(buttonView);
		views.addView(wavesView);
		views.addView(statsView);
		views.addView(healthBarView);
		views.addView(projectileView);
	}
  
	@Override
	public void render () {
		timer.UpdateTime(Gdx.graphics.getDeltaTime());

		collisionDetection.CheckCollisionPlayerAndEnemy(player);
		collisionDetection.CheckCollisionPlayerNextStep(player);
		collisionDetection.CheckCollisionEnemyAndHitBox(player);
		collisionDetection.CheckCollisionTowerAndEnemy(tower);
		collisionDetection.CheckCollisionTowerAndFireAttack(tower);
		collisionDetection.checkCollisionPlayerAndFireAttack(player);

		List<IProjectile> projectileGround = collisionDetection.checkCollisionProjectileGround();
		Map<Entity,IProjectile> projectileEnemy = collisionDetection.checkCollisionProjectileAndEnemy();
		playerController.UpdatePlayerMovement();
		projectileHandler.updateProjectiles(projectileEnemy,projectileGround);
		tower.fireTurrets();
		ScreenUtils.clear(0, 0, 0, 0);
		views.render();
	}
	
	@Override
	public void dispose () {
		views.dispose();

	}
}
