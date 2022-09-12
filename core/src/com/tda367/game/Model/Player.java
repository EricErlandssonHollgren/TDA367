package com.tda367.game.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.tda367.game.Controller.KeyController;

public class Player {
    KeyController key;
    private Vector2 position;
    private Vector2 velocity;
    private Texture player;
    private float speed = 5.0f;

    public Player(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;

    }

   /* public void Move(){
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            position.x += Gdx.graphics.getDeltaTime()*speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            position.x -= Gdx.graphics.getDeltaTime()*speed;
        }
    }*/

}
