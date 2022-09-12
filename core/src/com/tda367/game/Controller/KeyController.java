package com.tda367.game.Controller;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.tda367.game.Model.Player;

public class KeyController  {
    private static KeyController keyController;
    private final InputProcessor inputProcessor = new InputAdapter(){};

    private static Player player;
    private float frameTime = 1/15f;
    private Vector2 playerVelocity;

    private KeyController(){
        keyController = new KeyController();

    }

    public static KeyController getInstance(){
        if(keyController == null){
            keyController = new KeyController();
        }
        return keyController;
    }

   /* private void Update(SpriteBatch spriteBatch){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            spriteBatch.draw -= Gdx.graphics.getDeltaTime()*frameTime;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.getPosX() += Gdx.graphics.getDeltaTime()*frameTime;
        }
    }

    */

}
