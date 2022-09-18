package Model;

import com.badlogic.gdx.Gdx;
import Interfaces.PlayerPositionSubscriber;
import java.util.ArrayList;
import java.util.List;

public class Player {
    List<PlayerPositionSubscriber> subscriberList = new ArrayList<>();
    private float x;
    private float y;

    public Player(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void positionSubscriber(PlayerPositionSubscriber subscriber){
        subscriberList.add(subscriber);
        subscriber.updatePosition(x, y);
    }

    public void moveLeft(){
        x -= 15f;
        for (PlayerPositionSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(x,y);
        }
    }

    public void moveRight(){
        x += 15f;
        for (PlayerPositionSubscriber playerPositionSubscriber : subscriberList) {
            playerPositionSubscriber.updatePosition(x,y);
        }
    }

    public float getPosY(){
        return y;
    }
    public float getPosX(){
        return x;
    }


}
