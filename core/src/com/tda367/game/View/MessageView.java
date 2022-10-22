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

    /**
     *  Creates the view for the messeges.
     */
    public MessageView() {
        message = null;
        clickedTime = 10f;
        gameTimer = GameTimer.GetInstance();
        facade = new DrawFacade();
        System.out.println("here");
    }

    /**
     * Renders a message if there is a message.
     */
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
    public void dispose() {}

    /**
     * Updates the current message
     * @param message A string
     */
    @Override
    public void UpdateMessage(String message) {
        this.message = message;
        messageTime = gameTimer.GetTime();
    }

}
