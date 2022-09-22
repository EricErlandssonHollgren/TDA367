package com.tda367.game;

import Interfaces.IView;
import Model.GameTimer;
import Model.Projectile;
import Model.ViewHolder;
import View.ProjectileView;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

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
		views = new ViewHolder();
		world = new World(new Vector2(0,-0.5f),true);
		batch = new SpriteBatch();
		timer = GameTimer.GetInstance();
		img = new Texture("badlogic.jpg");
		//TODO

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
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
