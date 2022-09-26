package com.tda367.game;

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

	@Override
	public void create () {
		world = new World(new Vector2(0,-0.5f),true);
		views = new ViewHolder(world);
		batch = new SpriteBatch();

		timer = GameTimer.GetInstance();
		img = new Texture("badlogic.jpg");
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
