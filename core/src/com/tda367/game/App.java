package com.tda367.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import Controller.KeyListener;
import Model.Player;
import View.PlayerView;

public class App extends ApplicationAdapter {

	PlayerView view = new PlayerView(new Player(40f, 50f));
	@Override
	public void create () {
		view.create();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		view.render();
	}
	
	@Override
	public void dispose () {
		view.dispose();
	}
}
