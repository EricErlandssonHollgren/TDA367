package com.tda367.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class KeyController {

    public Input.Keys keys;

    public KeyController(Input.Keys keys){
        keyIsPressed();
        this.keys = keys;
    }
    public void keyIsPressed(){
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            keyIsPressed();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            keyIsPressed();
        }
    }
}
