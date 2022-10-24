package View;

import Interfaces.IMessageSubscriber;
import Interfaces.IView;
import View.Facade.DrawFacade;
import Model.GameTimer;
import com.badlogic.gdx.Gdx;

public class MessageView implements IView, IMessageSubscriber {

    private DrawFacade facade;
    private String message;
    private GameTimer gameTimer;
    private double messageTime;

    /**
     *  Creates the view for the messeges.
     */
    public MessageView() {
        message = null;
        gameTimer = GameTimer.GetInstance();
        facade = new DrawFacade();
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
    public void dispose() {facade.dispose();}

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
