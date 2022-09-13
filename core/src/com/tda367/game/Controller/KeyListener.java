package com.tda367.game.Controller;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.tda367.game.App;
import com.tda367.game.Interfaces.PlayerPositionSubscriber;
import com.tda367.game.Model.Player;

import javax.sound.midi.ShortMessage;


public class KeyListener implements PlayerPositionSubscriber {
    private Player player;
    private App app;
    private static KeyListener keyListener;
    private final InputProcessor inputProcessor = new InputAdapter(){};

    private float frameTime = 1/15f;
    private Vector2 playerVelocity;

    private KeyListener(){
        //this.player = player;
        //this.app = app;
        keyListener = new KeyListener();
    }

    public static KeyListener getInstance(){
        if(keyListener == null){
            keyListener = new KeyListener();
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

    @Override
    public void updatePosition(float x, float y) {

        //I vyn ska positionen sedan uppdateras
        //view.updatePosition(model.x, model.y) - kanske att jag kallar på Update metoden här?
        updatePosition(x,y);
    }
}
