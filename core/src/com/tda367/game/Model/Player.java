package com.tda367.game.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player{
    private Sprite playerSprite;
    private Vector2 velocity = new Vector2();
    private float frameTime = 1/15f;
    private final float x = Gdx.graphics.getWidth()/2 - playerSprite.getWidth()/2;
    private final float y = Gdx.graphics.getHeight()/2 - playerSprite.getHeight()/2;

    public Player(){
        this.playerSprite = new Sprite(getPlayerTexture());
    }

    public void draw(Batch playerBatchSprite, float x, float y) {
        //Centering the sprite
        playerSprite.setPosition(x,y);
        playerSprite.draw(playerBatchSprite);
    }
    public float getPosY(){
        return y;
    }
    public float getPosX(){
        return x;
    }

    public Texture getPlayerTexture(){
        //TODO: Using this for now until I have done the other parts.
        return new Texture(Gdx.files.internal("badlogic.jpg"));
    }


}
