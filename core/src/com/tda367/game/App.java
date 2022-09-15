package com.tda367.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tda367.game.View.RenderEnemy;

public class App extends ApplicationAdapter {

	RenderEnemy enemy1 = new RenderEnemy();
	
	@Override
	public void create () {
		enemy1.create();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		enemy1.render();
	}
	
	@Override
	public void dispose () {
		enemy1.dispose();
	}
}
