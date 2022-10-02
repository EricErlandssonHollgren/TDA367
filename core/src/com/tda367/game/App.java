package com.tda367.game;

import Model.GameTimer;
import Model.ViewHolder;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;


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
		timer.UpdateTime(Gdx.graphics.getDeltaTime());
		//System.out.println(timer.GetTime());
		batch.end();
	}
	
	@Override
	public void dispose () {

		batch.dispose();
		img.dispose();
		views.dispose();
	}
}
