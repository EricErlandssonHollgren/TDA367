package View;

import Model.Facade.DrawFacade;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.tda367.game.App;

public class MainMenuView extends ScreenAdapter {

    private final App game;
    private DrawFacade facade;
    private ImageButton StartButton;
    private ImageButton QuitButton;
    private Stage stage;


    public MainMenuView(App game) {
        facade = new DrawFacade();
        facade.setTexture("title.png");
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show(){
        createPlayButton();
        createQuitButton();
        addListeners();
        stage.addActor(StartButton);
        stage.addActor(QuitButton);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        facade.drawObject(Gdx.graphics.getWidth() * .5f - facade.getTexture().getWidth()*0.3f/2, Gdx.graphics.getHeight() * .65f, facade.getTexture().getWidth()*0.3f, facade.getTexture().getHeight()*0.3f);
        stage.draw();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();

    }

    private TextureRegionDrawable getTxrDrawable(Texture tx){
        TextureRegion txR = new TextureRegion(tx);
        return new TextureRegionDrawable(txR);
    }

    private void createPlayButton() {
        Texture textureStartbutton = new Texture("video-play-button.png");
        this.StartButton = new ImageButton(getTxrDrawable(textureStartbutton));
        this.StartButton.setSize(textureStartbutton.getWidth()*0.25f,textureStartbutton.getHeight()*0.25f);
        this.StartButton.setPosition(Gdx.graphics.getWidth() * 0.5f - textureStartbutton.getWidth()*0.25f/2, Gdx.graphics.getHeight() * 0.3f);
    }

    private void createQuitButton() {
        Texture textureQuitButton = new Texture("quit button.png");
        this.QuitButton = new ImageButton(getTxrDrawable(textureQuitButton));
        this.QuitButton.setSize(textureQuitButton.getWidth()*0.25f,textureQuitButton.getHeight()*0.25f);
        this.QuitButton.setPosition(Gdx.graphics.getWidth() * 0.5f - textureQuitButton.getWidth()*0.25f/2, Gdx.graphics.getHeight() * 0.1f);
    }

    private void addListeners() {
        this.StartButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen((Screen) new GameView(game));
            }
        });

        this.QuitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });
    }

}


