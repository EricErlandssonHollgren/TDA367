package View.Buttons;

import Controller.TowerController;
import Interfaces.IView;
import View.ButtonView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class UpgradeTowerButton extends ButtonView {
    private ImageButton upgradeTowerButton;
    private SpriteBatch batch;
    private Texture texture;
    private TextureRegion txRegion;
    private TextureRegionDrawable txrDrawable;

    private ClickListener clickListener;
    private TowerController controller;
    private Stage stage;

    public UpgradeTowerButton(TowerController towerController, float posX, float posY, float sizeW, float sizeH) {
        super(towerController, posX, posY, sizeW, sizeH);
        this.texture = new Texture("badlogic.jpg");
        this.txRegion = new TextureRegion(texture);
        this.txrDrawable = new TextureRegionDrawable(txRegion);
        this.upgradeTowerButton = new ImageButton(txrDrawable);

        upgradeTowerButton.setPosition(posX,posY);
        upgradeTowerButton.setSize(sizeW,sizeH);

        this.stage = new Stage(new ScreenViewport());
        stage.addActor(upgradeTowerButton);

        Gdx.input.setInputProcessor(stage);

        this.batch = new SpriteBatch();
        controller = towerController;

        this.clickListener = new ClickListener(){
            @Override
            public void clicked (InputEvent event, float x, float y){
                controller.upgradeTower();
                System.out.println("Pressed!");
            }
        };

        upgradeTowerButton.addListener(this.clickListener);
    }


    @Override
    public void render(){
        stage.draw();
    }

    @Override
    public void dispose(){
        batch.dispose();
        stage.dispose();
    }
}
