package Interfaces;

import Model.ActionEnum;

public interface IEntitySubscriber {

    void updatePosition(float x, float y);

    void updateState(ActionEnum action);

}
