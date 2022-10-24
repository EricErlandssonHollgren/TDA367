package View;

import Interfaces.IGameOverSubscriber;
import Interfaces.IMessageSubscriber;

/**
 * A view to test the observers
 */
public class ObserverTestView implements IGameOverSubscriber, IMessageSubscriber {

    private boolean screenUpdated = false;
    private String s = null;

    /**
     * updates screen.
     */
    @Override
    public void updateScreen() {
        screenUpdated = true;
    }

    /**
     * Updates the s variable with the message.
     * @param message
     */
    @Override
    public void UpdateMessage(String message) {
        s = message;
    }

    /**
     * Returns the message sent
     * @return
     */
    public String getMessage() {
        return s;
    }

    /**
     * Returns if the screen has been updated.
     * @return
     */
    public boolean getScreenUpdated() {
        return screenUpdated;
    }
}
