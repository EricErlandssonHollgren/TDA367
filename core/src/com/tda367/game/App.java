package com.tda367.game;

import Controller.KeyListener;
import Interfaces.IView;
import Model.*;
import Model.Enemy.Enemies.Enemy1;
import Model.Enemy.Enemy;
import View.PlayerView;
import Interfaces.IView;
import View.ProjectileView;
import Interfaces.IView;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import View.EnemyView;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class App extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	World world;
	GameTimer timer;
	ViewHolder views;
	OrthographicCamera camera;
	Ground ground;


	public void create () {
		world = new World(new Vector2(0, -10), true);
		views = new ViewHolder(world);
		batch = new SpriteBatch();

		timer = GameTimer.GetInstance();
		img = new Texture("badlogic.jpg");

		ground = new Ground();
		Box2D.init();

		//TODO

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		views.render();

		batch.end();
	}
	
	@Override
	public void dispose () {

		batch.dispose();
		img.dispose();
		views.dispose();
	}
}
