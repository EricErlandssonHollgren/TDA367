package com.tda367.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tda367.game.Controller.KeyListener;
import com.tda367.game.Model.Player;

public class App extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	KeyListener keyListener;

	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();


	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		player.draw(batch, player.getPosX(), player.getPosY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
