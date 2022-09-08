package com.tda367.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tda367.game.Model.GameTimer;
import com.tda367.game.Model.RoundHandler;

public class App extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private RoundHandler roundHandler;
	private GameTimer gameTimer;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		gameTimer = GameTimer.GetInstance();
		roundHandler = RoundHandler.GetInstance();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		gameTimer.UpdateTime();
		gameTimer.GetTime();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
