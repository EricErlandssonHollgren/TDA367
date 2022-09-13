package com.tda367.game.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.tda367.game.Controller.KeyListener;
import com.tda367.game.Interfaces.PlayerPositionSubscriber;

import java.util.ArrayList;
import java.util.List;

public class Player  {

    List<PlayerPositionSubscriber> subscriberList = new ArrayList<>();
    private Sprite playerSprite;
    private Vector2 velocity = new Vector2();
    private float frameTime = 15f;
    private float x;
    private float y;

    public Player(){
        this.playerSprite = new Sprite(getPlayerTexture());
    }

    public void draw(Batch playerBatchSprite, float x, float y) {
        //Centering the sprite
        playerSprite.setPosition(x,y);
        playerSprite.draw(playerBatchSprite);

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            moveRight();
        }
    }
    public void positionSubscriber(PlayerPositionSubscriber subscriber){
        subscriberList.add(subscriber);
    }

    public void moveLeft(){
        x -= Gdx.graphics.getDeltaTime()*frameTime;
    }

    public void moveRight(){
        x += Gdx.graphics.getDeltaTime()*frameTime;
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
