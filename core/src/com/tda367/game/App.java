package com.tda367.game;

import Controller.ProjectileController;
import Controller.TowerController;
import Interfaces.IProjectile;
import Interfaces.IView;
import Controller.PlayerController;
import Model.*;
import View.*;
import View.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.List;
import java.util.Map;

public class App extends Game {
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
	private ProjectileController projectileController;

	/**
	 * Initialises the model in the startup configuration, is called when the application starts
	 */
	@Override
	public void create () {
		setScreen(new MainMenuView(this));
	}
  
	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		views.dispose();

	}
}
