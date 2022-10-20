package View;

import Interfaces.IMessageSubscriber;
import Interfaces.IView;
import Model.Facade.DrawFacade;
import Model.GameTimer;
import Model.Goldhandler;
import Model.PointHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MessageView implements IView, IMessageSubscriber {

    private DrawFacade facade;
    private String message;
    private GameTimer gameTimer;
    private double messageTime, clickedTime;

    public MessageView() {
        facade = new DrawFacade();
        message = null;
        gameTimer = GameTimer.GetInstance();
        clickedTime = 10f;
    }

    @Override
    public void render() {
        if (message != null && gameTimer.GetTime() - messageTime <= 2 ) {
            facade.drawText(message, Gdx.graphics.getWidth() * .4f, Gdx.graphics.getHeight() * .7f);
        }
        else {
            message = null;
        }
    }

    @Override
    public void dispose() {

    }

    @Override
    public void UpdateMessage(String message) {
        this.message = message;
        messageTime = gameTimer.GetTime();
    }

}
