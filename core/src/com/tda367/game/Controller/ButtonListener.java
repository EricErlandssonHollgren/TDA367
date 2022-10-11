/*package Controller;

import View.ButtonView;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import View.ButtonHolder;
import java.util.ArrayList;
import java.util.List;


public class ButtonListener {

    public ButtonListener(final ButtonHolder buttons) {

        new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                for (ButtonView b : buttons.buttonList) {
                    if ((b.getPositionX() == x) == (b.getPositionY() == y)) {
                        b.pressed();
                    }
                }
            }
        };
    }

}
*/