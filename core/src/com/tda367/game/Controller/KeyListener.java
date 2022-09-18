package Controller;

import com.badlogic.gdx.*;
import Model.Player;



public class KeyListener{
    Player player;

    public KeyListener(Player player){
        this.player = player;
    }

    public void UpdatePlayerPosition(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            player.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            player.moveRight();
        }
    }


}
