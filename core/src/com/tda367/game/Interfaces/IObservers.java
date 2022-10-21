package Interfaces;
import Model.ActionEnum;

/**
 * A class that implements this interface should be an observer that is called to different actions by a controller.
 */
public interface IObservers {

    /**
     * Handles an action. Called from a controller, executed within model.
     * @param action , an ENUM specifying what action should be executed.
     */
    void actionHandle(ActionEnum action);
}
