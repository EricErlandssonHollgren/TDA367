package com.tda367.game;

import Controller.PlayerKeyListener;
import Controller.TowerController;
import Interfaces.IPlayerSubscriber;
import Interfaces.IView;
import Model.*;
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
		//Model
		//Handlers
		player = new Player(120,100);
		worldBoundaries = new WorldBoundaries();

		timer = GameTimer.GetInstance();
		//setup chain of responsibility?
		goldHandler = new Goldhandler();
		pointsHandler = new PointHandler();
		goldHandler.setSuccessor(pointsHandler);

		roundHandler = RoundHandler.GetInstance(timer);


		//Instantiates Tower, (needs to be done after instantiating Goldhandler).
		tower = new Tower((Goldhandler) goldHandler);

		entityHolder = EntityHolder.getInstance();
		collisionDetection = CollisionDetection.getInstance();

		//Controllers
		playerKeyListener = new PlayerKeyListener();
		playerKeyListener.addSubscribers(player);
		towerController = new TowerController();
		towerController.addSubscribers(tower);

		//Create views and objects
		IView worldBoundariesView = new WorldBoundariesView(worldBoundaries);
		IView playerView = new PlayerView();
		IView towerView = new TowerView(tower);
		IView background = new BackgroundView();
		IView buttonView = new ButtonView(towerController, tower);

		player.positionSubscriber((IPlayerSubscriber) playerView);

		//Add views to list and they will be rendered. Views must implement IView
		views = new ViewHolder();
		views.addView(background);
		views.addView(worldBoundariesView);
		views.addView(playerView);
		views.addView(towerView);
		views.addView(buttonView);
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
