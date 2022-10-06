package View;

import Controller.TowerController;
import Interfaces.IView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class ButtonView implements IView {

    private ImageButton upgradeButton;
    private SpriteBatch batch;
    private Texture texture;
    private TextureRegion txRegion;
    private TextureRegionDrawable txrDrawable;

    private TowerController controller;
    private Stage stage;
    private Skin skin;

    public ButtonView(TowerController towerController) {
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
        controller = towerController;

        upgradeButton.addListener(new ClickListener(){
            @Override
            public void clicked (InputEvent event, float x, float y){
                controller.upgradeTower();
                System.out.println("Pressed!");
            }
        });
    }

    @Override
    public void render() {
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }
}
