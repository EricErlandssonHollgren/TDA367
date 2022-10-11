package View;


import java.util.ArrayList;
import java.util.List;


public class ButtonHolder{
    public List<ButtonView> buttonList;

    public ButtonHolder() {
        this.buttonList = new ArrayList<>();

    }

    public void addButton(ButtonView button) {
        buttonList.add(button);
    }
}