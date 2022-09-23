package com.tda367.game;

import Model.*;
import View.StatsView;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class App extends ApplicationAdapter {

	StatsView a = new StatsView();

	@Override
	public void create () {
		a.create();
	}

	@Override
	public void render () {
		a.render();

	}
	
	@Override
	public void dispose () {
		a.dispose();
	}
}
