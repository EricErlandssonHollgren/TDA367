package View;

import Interfaces.IObservers;
import Model.ActionEnum;
import Model.Facade.DrawFacade;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameOverView extends ScreenAdapter {

    private Stage stage;
    private ImageButton PlayAgain;
    private ImageButton QuitButton;
    private DrawFacade facade;



    /**
     * Constructs the gameover view
     */
    public GameOverView() {
        facade = new DrawFacade();
        facade.setTexture("gameOver.png");
        this.stage = new Stage(new ScreenViewport());
    }

    /**
     * Creates all buttons when the gameOverView is constructing.
     */
    @Override
    public void show(){
        createPlayAgainButton();
        createQuitButton();
        addListeners();
        stage.addActor(PlayAgain);
        stage.addActor(QuitButton);
        Gdx.input.setInputProcessor(stage);
    }


    private void addListeners() {
        this.PlayAgain.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                ((Game)Gdx.app.getApplicationListener()).setScreen((Screen) new GameView());
            }
        });

        this.QuitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });
    }

    private void createQuitButton() {
        Texture textureQuitButton = new Texture("quit button.png");
        this.QuitButton = new ImageButton(getTxrDrawable(textureQuitButton));
        this.QuitButton.setSize(textureQuitButton.getWidth()*0.25f,textureQuitButton.getHeight()*0.25f);
        this.QuitButton.setPosition(Gdx.graphics.getWidth() * 0.5f - textureQuitButton.getWidth()*0.25f/2, Gdx.graphics.getHeight() * 0.2f);
    }

    private void createPlayAgainButton() {
        Texture textureStartbutton = new Texture("playAgain.png");
        this.PlayAgain = new ImageButton(getTxrDrawable(textureStartbutton));
        this.PlayAgain.setSize(textureStartbutton.getWidth()*0.25f,textureStartbutton.getHeight()*0.25f);
        this.PlayAgain.setPosition(Gdx.graphics.getWidth() * 0.5f - textureStartbutton.getWidth()*0.25f/2, Gdx.graphics.getHeight() * 0.4f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        facade.drawObject(Gdx.graphics.getWidth() * .5f - facade.getTexture().getWidth()*0.3f/2, Gdx.graphics.getHeight() * .65f, facade.getTexture().getWidth()*0.3f, facade.getTexture().getHeight()*0.3f);
        stage.draw();
    }

    @Override
    public void dispose() {}

    private TextureRegionDrawable getTxrDrawable(Texture tx){
        TextureRegion txR = new TextureRegion(tx);
        return new TextureRegionDrawable(txR);
    }
}
