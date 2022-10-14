package View;

import Controller.TowerController;
import Model.Tower;
import Interfaces.IView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

 /**
  * @author Jonatan Jageklint <jonatan.jage@gmail.com>
  * @author Eric Erlandsson Hollgren <eric.e.hollgren@gmail.com>
 */

public class ButtonView implements IView {
    private TowerController controller;
    private Tower tower;
    private ImageButton upgradeButtonTower;
    private ImageButton upgradeButtonTurret;
    private ImageButton upgradeButtonTurret2;
    private ImageButton buildButtonTurret;

    private Stage stage;

     /**
      * A constructor for ButtonView.
      * This creates buttons that when clicked, upgrades Tower with Turrets and upgrades them.'
      */
    public ButtonView(TowerController towerController, Tower tower) {
        this.controller = towerController;
        this.tower = tower;
        initButtons();
        addListeners();

        this.stage = new Stage(new ScreenViewport());
        stage.addActor(upgradeButtonTower);
        stage.addActor(upgradeButtonTurret);
        stage.addActor(upgradeButtonTurret2);
        stage.addActor(buildButtonTurret);
        Gdx.input.setInputProcessor(stage);
    }


    /*
    Method for setting up texture.
     */
    private TextureRegionDrawable getTxrDrawable(Texture tx){
        TextureRegion txR = new TextureRegion(tx);
        return new TextureRegionDrawable(txR);
    }

    /*
    Sets up the buttons textures, sizes and positions.
     */
    private void initButtons(){
        Texture textureUpgradeTower = new Texture("badlogic.jpg");
        this.upgradeButtonTower = new ImageButton(getTxrDrawable(textureUpgradeTower));
        this.upgradeButtonTower.setSize(70,40);
        this.upgradeButtonTower.setPosition(50,40);

        Texture textureUpgradeTurret = new Texture("badlogic.jpg");
        this.upgradeButtonTurret = new ImageButton(getTxrDrawable(textureUpgradeTurret));
        this.upgradeButtonTurret.setVisible(false);
        this.upgradeButtonTurret.setSize(30,30);
        this.upgradeButtonTurret.setPosition(120,200);

        Texture textureUpgradeTurret2 = new Texture("badlogic.jpg");
        this.upgradeButtonTurret2 = new ImageButton(getTxrDrawable(textureUpgradeTurret2));
        this.upgradeButtonTurret2.setVisible(false);
        this.upgradeButtonTurret2.setSize(30,30);
        this.upgradeButtonTurret2.setPosition(120,250);

        Texture textureBuildTurret = new Texture("badlogic.jpg");
        this.buildButtonTurret = new ImageButton(getTxrDrawable(textureBuildTurret));
        this.buildButtonTurret.setSize(70,40);
        this.buildButtonTurret.setPosition(150,40);
    }

    /*
    Adds listeners to the buttons that informs controller of specific inputs by the user.
     */
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
                controller.upgradeTower();
                System.out.println("uTurret1");}
        });
        this.upgradeButtonTurret2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){
                    controller.upgradeTower();
                    System.out.println("uTurret2");
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

    /*
    Makes button for upgrading specific turrets visible after viewing model to see that corresponding turrets exist.
     */
    private void updateButtonVisibility(){
        if(tower.getTurrets().size() == 1){
            this.upgradeButtonTurret.setVisible(true);
        }
        if(tower.getTurrets().size() == 2){
            this.upgradeButtonTurret2.setVisible(true);
        }
    }

    @Override
    public void render() {
        updateButtonVisibility();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
