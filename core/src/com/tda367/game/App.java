package com.tda367.game;


import View.*;
import com.badlogic.gdx.Game;


public class App extends Game {


	/**
	 * Initialises the model in the startup configuration, is called when the application starts
	 */
	@Override
	public void create() {
		this.setScreen(new MainMenuView());
	}

	public void render() {
		super.render();
	}



}
