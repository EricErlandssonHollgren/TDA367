package com.tda367.game;

import Controller.ProjectileController;
import Controller.TowerController;
import Interfaces.IProjectile;
import Interfaces.IView;
import Controller.PlayerController;
import Interfaces.IEntitySubscriber;
import Model.*;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;
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

	private Enemy enemy;
	private RoundHandler roundHandler;
	private MainHandler goldHandler;
	private MainHandler pointsHandler;
	private Tower tower;
	private HealthBar healthBar;

	private WorldBoundaries worldBoundaries;
	private CollisionDetection collisionDetection;
	private EntityHolder entityHolder;
	private TowerController towerController;
	private PlayerController playerController;
	private ProjectileController projectileController;

	public App() {
	}

	/**
	 * Initialises the model in the startup configuration, is called when the application starts
	 */
	@Override
	public void create () {
		//Handlers
		enemy = EnemyFactory.createEnemy1();
		player = new Player(120,100, 50, 37);
		healthBar = new HealthBar(player.getPosX(), player.getPosY(), player.getHealth(), player.getWidth(), player.getHeight());
		worldBoundaries = new WorldBoundaries();
		timer = GameTimer.GetInstance();

		//Handlers
		goldHandler = new Goldhandler();
		pointsHandler = new PointHandler();
		goldHandler.setSuccessor(pointsHandler);

		roundHandler = RoundHandler.GetInstance(timer);


		//Instantiates Tower, (needs to be done after instantiating Goldhandler).
		tower = new Tower((Goldhandler) goldHandler);

		entityHolder = EntityHolder.getInstance();
		collisionDetection = CollisionDetection.getInstance();

		//Controllers
		towerController = new TowerController();
		towerController.addSubscribers(tower);
		playerController = new PlayerController();
		playerController.addSubscribers(player);
		towerController = new TowerController();
		towerController.addSubscribers(tower);
		projectileController = new ProjectileController(entityHolder,collisionDetection,timer);

		//Create views and objects
		IView worldBoundariesView = new WorldBoundariesView(worldBoundaries);
		IView enemyView = ViewFactory.createEnemyView();
		IView playerView = new PlayerView();
		IView fireView = new FireView(enemy.enemyAttack);
		IView towerView = new TowerView(tower);
		IView buttonView = new ButtonView(towerController, tower);
		IView healthBarView = new HealthBarView(player.healthBar);
		IView statsView = new StatsView();
		IView background = new BackgroundView();
		IView projectileView = new ProjectileView(projectileController);
		player.positionSubscriber((IEntitySubscriber) playerView);

		//Add views to list and they will be rendered. Views must implement IView
		views = new ViewHolder();
		views.addView(background);
		views.addView(worldBoundariesView);
		views.addView(playerView);
		views.addView(towerView);
		views.addView(buttonView);
		views.addView(enemyView);
		views.addView(fireView);
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

		List<IProjectile> projectileGround = collisionDetection.checkCollisionProjectileGround();
		Map<Entity,IProjectile> projectileEnemy = collisionDetection.checkCollisionProjectileAndEnemy();
		playerController.UpdatePlayerMovement();
		projectileController.updateProjectiles(projectileEnemy,projectileGround);
		playerController.UpdatePlayerState();
		ScreenUtils.clear(0, 0, 0, 0);
		views.render();
	}
	
	@Override
	public void dispose () {
		views.dispose();

	}
}
