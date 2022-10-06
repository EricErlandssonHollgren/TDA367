package View;

import Controller.TowerKeyListener;
import Interfaces.IView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.event.MouseEvent;

public class ButtonView implements IView {

    private ImageButton upgradeButton;
    private SpriteBatch batch;
    private Texture texture;
    private TextureRegion txRegion;
    private TextureRegionDrawable txrDrawable;

    private TowerKeyListener controller;
    private Stage stage;
    private Skin skin;

    public ButtonView() {
        this.texture = new Texture("badlogic.jpg");
        this.txRegion = new TextureRegion(texture);
        this.txrDrawable = new TextureRegionDrawable(txRegion);
        this.upgradeButton = new ImageButton(txrDrawable);

        upgradeButton.setPosition(300,300);
        upgradeButton.setSize(60,60);

        this.stage = new Stage(new ScreenViewport());
        stage.addActor(upgradeButton);

        Gdx.input.setInputProcessor(stage);

        this.batch = new SpriteBatch();
        controller = new TowerKeyListener();

        upgradeButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {

                System.out.println("Pressed!");
                controller.upgradeTower();
                return true;
            }
        });
    }

    @Override
    public void render() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }
}
