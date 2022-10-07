package View.Buttons;

import Controller.TowerController;
import Model.Turret;
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

public class UpgradeTurretButton extends ButtonView {
    private ImageButton upgradeTurretButton;
    private SpriteBatch batch;
    private Texture texture;
    private TextureRegion txRegion;
    private TextureRegionDrawable txrDrawable;

    private int turretIndex;
    private TowerController controller;
    private Stage stage;
    private ClickListener clickListener;

    public UpgradeTurretButton(TowerController towerController, final int turretIndex, float posX, float posY, float sizeW, float sizeH) {
        super(towerController, posX, posY, sizeW, sizeH);
        this.texture = new Texture("badlogic.jpg");
        this.txRegion = new TextureRegion(texture);
        this.txrDrawable = new TextureRegionDrawable(txRegion);
        this.upgradeTurretButton = new ImageButton(txrDrawable);

        upgradeTurretButton.setPosition(posX,posY);
        upgradeTurretButton.setSize(sizeW,sizeH);

        this.stage = new Stage(new ScreenViewport());
        stage.addActor(upgradeTurretButton);
        Gdx.input.setInputProcessor(stage);

        this.clickListener = new ClickListener(){
            @Override
            public void clicked (InputEvent event, float x, float y){
                controller.upgradeTurret(turretIndex);
                System.out.println("Pressed!");
            }
        };

        upgradeTurretButton.addListener(this.clickListener);

        this.batch = new SpriteBatch();

        controller = towerController;
        this.turretIndex = turretIndex;

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
