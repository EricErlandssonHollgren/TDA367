package com.tda367.game;

import View.*;
import com.badlogic.gdx.Game;


public class App extends Game {

	/**
	 * Initialises the model in the startup configuration, is called when the application starts
	 */
	@Override
	public void create () {
		setScreen(new MainMenuView(this));
	}

	/**
	 * Called 60 times per second, renders the application
	 */
	@Override
	public void render () {
		super.render();

	}

	/**
	 * Disposes the objects in the application
	 */
	@Override
	public void dispose () {


	}
}
