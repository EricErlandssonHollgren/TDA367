package View.Buttons;

import Controller.TowerController;
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

public class BuildTurretButton extends ButtonView {
    private ClickListener clickListener;
    private ImageButton buildTurretButton;
    private SpriteBatch batch;
    private Texture texture;
    private TextureRegion txRegion;
    private TextureRegionDrawable txrDrawable;

    private TowerController controller;
    private Stage stage;

    public BuildTurretButton(TowerController towerController, float posX, float posY, float sizeW, float sizeH) {
        super(towerController, posX, posY, sizeW, sizeH);
        this.texture = new Texture("badlogic.jpg");
        this.txRegion = new TextureRegion(texture);
        this.txrDrawable = new TextureRegionDrawable(txRegion);
        this.buildTurretButton = new ImageButton(txrDrawable);

        buildTurretButton.setPosition(posX,posY);
        buildTurretButton.setSize(sizeW,sizeH);

        this.stage = new Stage(new ScreenViewport());
        stage.addActor(buildTurretButton);

        Gdx.input.setInputProcessor(stage);

        this.batch = new SpriteBatch();
        controller = towerController;

        this.clickListener = new ClickListener(){
            @Override
            public void clicked (InputEvent event, float x, float y){
                controller.buildTurret();
                System.out.println("Pressed!");
            }
        };

        buildTurretButton.addListener(this.clickListener);
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
