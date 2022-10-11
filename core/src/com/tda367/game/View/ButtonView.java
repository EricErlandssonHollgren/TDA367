package View;

import Controller.TowerController;
import Interfaces.IView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.List;

public class ButtonView implements IView {
    private TowerController controller;
    private ImageButton upgradeButtonTower;
    private ImageButton upgradeButtonTurret;
    private ImageButton buildButtonTurret;

    private Stage stage;

    public ButtonView(TowerController towerController) {
        this.controller = towerController;
        initButtons();
        addListeners();

        this.stage = new Stage(new ScreenViewport());
        stage.addActor(upgradeButtonTower);
        stage.addActor(upgradeButtonTurret);
        stage.addActor(buildButtonTurret);
        Gdx.input.setInputProcessor(stage);
    }

    private TextureRegionDrawable getTxrDrawable(Texture tx){
        TextureRegion txR = new TextureRegion(tx);
        return new TextureRegionDrawable(txR);
    }

    private void initButtons(){
        Texture textureUpgradeTower = new Texture("badlogic.jpg");
        this.upgradeButtonTower = new ImageButton(getTxrDrawable(textureUpgradeTower));
        this.upgradeButtonTower.setSize(100,100);
        this.upgradeButtonTower.setPosition(100,400);

        Texture textureUpgradeTurret = new Texture("badlogic.jpg");
        this.upgradeButtonTurret = new ImageButton(getTxrDrawable(textureUpgradeTurret));
        this.upgradeButtonTurret.setVisible(false);
        this.upgradeButtonTurret.setSize(10,40);
        this.upgradeButtonTurret.setPosition(300,480);

        Texture textureBuildTurret = new Texture("badlogic.jpg");
        this.buildButtonTurret = new ImageButton(getTxrDrawable(textureBuildTurret));
        this.buildButtonTurret.setSize(20,40);
        this.buildButtonTurret.setPosition(200,400);
    }

    private void addListeners(){
        this.upgradeButtonTower.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                controller.upgradeTower();
                System.out.println("uTower");
            }
        });
        this.upgradeButtonTurret.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                //controller.upgradeTurret();
                System.out.println("uTurret");
            }
        });
        this.buildButtonTurret.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                controller.buildTurret();
                System.out.println("bTurret");
            }
        });
    }

    @Override
    public void render() {
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
