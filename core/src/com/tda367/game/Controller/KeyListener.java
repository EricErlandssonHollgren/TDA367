package com.tda367.game.Controller;

import com.badlogic.gdx.*;
import com.tda367.game.Model.Player;



public class KeyListener{
    Player player;

    public KeyListener(Player player){
        this.player = player;
    }

    public void UpdatePlayerPosition(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.moveRight();
        }
    }


}
