package com.tda367.game;

import Interfaces.IView;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import Controller.KeyListener;
import Model.Player;
import View.PlayerView;

import java.util.ArrayList;
import java.util.List;

public class App extends ApplicationAdapter {

	List<IView> views;
	SpriteBatch batch;
	KeyListener keyListener;
	@Override
	public void create () {

		views = new ArrayList<>();
		batch = new SpriteBatch();
		Player player = new Player(40f, 50f);
		keyListener = new KeyListener();
		PlayerView playerView = new PlayerView();

		keyListener.addSubscribers(player);
		player.positionSubscriber(playerView);
		views.add(playerView);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		keyListener.UpdatePlayerPosition();
		for (int i = 0; i <=views.size()-1; i++) {
			views.get(i).render();

		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		for (int i = 0; i <= views.size()-1; i++) {
			views.get(i).dispose();
		}
	}
}
