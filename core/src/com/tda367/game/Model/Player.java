package com.tda367.game.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {
    private int posX;

    public Player(int x){
        this.posX = x;
    }

    public boolean pressedKey(){
        float moveAmount;
        boolean keyD = Gdx.input.isKeyPressed(Input.Keys.D);
        boolean keyA = Gdx.input.isKeyPressed(Input.Keys.A);
        if(keyD){
            moveAmount = 5.0f;
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_RIGHT)){
                posX += moveAmount;
            }
        }
        if(keyA){
            moveAmount = 10.0f;
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT));
            {
                posX -= moveAmount;
            }
        }

        return true;
    }

    public void Move(){
        pressedKey();
    }
}
