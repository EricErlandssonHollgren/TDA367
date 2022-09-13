package com.tda367.game.Controller;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.tda367.game.App;
import com.tda367.game.Model.Player;

import javax.sound.midi.ShortMessage;


public class KeyListener  {
    private Player player;
    private App app;
    private static KeyListener keyListener;
    private final InputProcessor inputProcessor = new InputAdapter(){};

    private float frameTime = 1/15f;
    private Vector2 playerVelocity;

    private KeyListener(Player player, App app){
        this.player = player;
        this.app = app;
        keyListener = new KeyListener(player, app);
    }

    public static KeyListener getInstance(){
        if(keyListener == null){
            keyListener = new KeyListener(getInstance().player, getInstance().app);
        }
        return keyListener;
    }

   private void Update(Sprite spriteBatch){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.moveRight();
        }
    }


}
