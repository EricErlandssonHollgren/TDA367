package Controller;

import com.badlogic.gdx.*;
import Model.Player;



public class KeyListener{
    Player player;

    /**
     * Constructor when creating a KeyListener. The constructor is mainly used for
     * creating a KeyListener which listens to when keys are being pressed.
     * @param player represents the player
     */
    public KeyListener(Player player){
        this.player = player;
    }

    /**
     * UpdatePlayerPosition listens to inputs depending on which key is pressed.
     * When being listened it tells the player to either use moveLeft()-
     * or moveRight()-method.
     */
    public void UpdatePlayerPosition(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            player.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            player.moveRight();
        }
    }


}
