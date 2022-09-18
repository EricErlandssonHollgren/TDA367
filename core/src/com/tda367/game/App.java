package com.tda367.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import Controller.KeyListener;
import Model.Player;
import View.PlayerView;

public class App extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	PlayerView view;
	KeyListener keyListener;
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player(40f, 50f);
		keyListener = new KeyListener(player);
		view = new PlayerView(player);
		player.positionSubscriber(view);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		view.draw(batch);
		keyListener.UpdatePlayerPosition();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
