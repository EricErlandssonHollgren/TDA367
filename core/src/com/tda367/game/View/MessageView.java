package View;

import Interfaces.IMessageSubscriber;
import Interfaces.IView;
import Model.Facade.DrawFacade;
import Model.GameTimer;
import com.badlogic.gdx.Gdx;

public class MessageView implements IView, IMessageSubscriber {

    private DrawFacade facade;
    private String message;
    private GameTimer gameTimer;
    private double messageTime, clickedTime;

    public MessageView() {
        message = null;
        clickedTime = 10f;
        gameTimer = GameTimer.GetInstance();
        facade = new DrawFacade();
        System.out.println("here");
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
