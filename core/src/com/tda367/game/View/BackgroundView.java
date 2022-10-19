package View;

import Interfaces.IView;
import Model.Facade.DrawFacade;

public class BackgroundView implements IView {
    private DrawFacade drawFacade;
    public BackgroundView(){
        drawFacade = new DrawFacade();
        drawFacade.setTexture("Game_Background_175.png");
    }
    @Override
    public void render() {
        drawFacade.drawObject(0,0,1000,1000);
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }
}
