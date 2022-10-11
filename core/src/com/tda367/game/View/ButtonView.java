package View;

import Controller.TowerController;
import Interfaces.IView;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.List;

public class ButtonView implements IView {

    private TowerController controller;
    List<ImageButton> buttons;

    private Texture texture;
    private TextureRegion txRegion;
    private TextureRegionDrawable txrDrawable;

    private ClickListener clickListener;
    private Stage stage;

    public ButtonView(TowerController towerController, float posX, float posY, float sizeW,float sizeH) {

        this.texture = new Texture("badlogic.jpg");
        this.txRegion = new TextureRegion(texture);
        this.txrDrawable = new TextureRegionDrawable(txRegion);
        this.buttonImage = new ImageButton(txrDrawable);

        this.controller = towerController;
        buttonImage.setPosition(posX,posY);
        buttonImage.setSize(sizeW,sizeH);

        this.clickListener = new ClickListener(){
            @Override
            public void clicked (InputEvent event, float x, float y){
                controller.buildTurret();
                System.out.println("Pressed!");
            }
        };
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        this.batch = new SpriteBatch();
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
