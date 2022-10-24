package View;

import Interfaces.IView;
import View.Facade.DrawFacade;

public class BackgroundView implements IView {
    private DrawFacade drawFacade;

    /**
     * A constructor for the view of the background of the application.
     */
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
