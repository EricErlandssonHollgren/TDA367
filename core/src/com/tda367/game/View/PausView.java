package View;

import Interfaces.IPaus;
import Interfaces.IView;
import Model.Facade.DrawFacade;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PausView implements IView, IPaus {
    private final Stage stage;
    DrawFacade facade;
    private ImageButton QuitButton;
    private ImageButton PlayAgain;
    public boolean isGamePaused = false;

    public PausView() {
        this.stage = new Stage(new ScreenViewport());
        facade = new DrawFacade();
        facade.setTexture("paus.png");
        create();
    }

    public void create() {
        createPlayAgainButton();
        createQuitButton();
        addListeners();
        stage.addActor(PlayAgain);
        stage.addActor(QuitButton);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        if (isGamePaused) {
            facade.drawObject(Gdx.graphics.getWidth() * 0.5f - 200, Gdx.graphics.getHeight() * 0.5f - 200, 400, 400);
            facade.drawText("Game Paused", 270, 350);
            QuitButton.setVisible(true);
            PlayAgain.setVisible(true);
            stage.draw();
        }
        else {
            QuitButton.setVisible(false);
            PlayAgain.setVisible(false);
        }
    }

    @Override
    public void dispose() {

    }

    private void createQuitButton() {
        Texture textureQuitButton = new Texture("quit button.png");
        this.QuitButton = new ImageButton(getTxrDrawable(textureQuitButton));
        this.QuitButton.setSize(textureQuitButton.getWidth() * 0.25f, textureQuitButton.getHeight() * 0.25f);
        this.QuitButton.setPosition(Gdx.graphics.getWidth() * 0.5f - textureQuitButton.getWidth() * 0.25f / 2, Gdx.graphics.getHeight() * 0.2f );
    }


    private void createPlayAgainButton() {
        Texture textureStartbutton = new Texture("playAgain.png");
        this.PlayAgain = new ImageButton(getTxrDrawable(textureStartbutton));
        this.PlayAgain.setSize(textureStartbutton.getWidth() * 0.25f, textureStartbutton.getHeight() * 0.25f);
        this.PlayAgain.setPosition(Gdx.graphics.getWidth() * 0.5f - textureStartbutton.getWidth() * 0.25f / 2, Gdx.graphics.getHeight() * 0.4f);
    }

    private TextureRegionDrawable getTxrDrawable(Texture tx) {
        TextureRegion txR = new TextureRegion(tx);
        return new TextureRegionDrawable(txR);
    }

    private void addListeners() {
        this.PlayAgain.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });

        this.QuitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }


    @Override
    public void IsGamePaused(boolean isGamePaused) {
        this.isGamePaused = isGamePaused;
    }
}
