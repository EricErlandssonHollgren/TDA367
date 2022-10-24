package View;

import Controller.PlayerSpawnController;
import Controller.TowerController;
import Interfaces.IPaus;
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

public class ButtonView implements IView, IPaus {
    private TowerController controller;
    private PlayerSpawnController playerSpawnController;
    private Tower tower;
    private ImageButton upgradeButtonTower;
    private ImageButton upgradeButtonTurret;
    private ImageButton upgradeButtonTurret2;
    private ImageButton buildButtonTurret;
    private ImageButton respawnPlayerButton;

    private Stage stage;

     /**
      * A constructor for ButtonView.
      * This creates buttons that when clicked, upgrades Tower with Turrets and upgrades them.
      * @param towerController, the controller that is notified when a specific button is clicked.
      * @param tower, the object that is viewed. Depending on it, different buttons are rendered.
      * @param playerSpawnController, the controller that tells the player to respawn
      */
    public ButtonView(TowerController towerController, Tower tower, PlayerSpawnController playerSpawnController) {
        this.controller = towerController;
        this.tower = tower;
        this.playerSpawnController = playerSpawnController;
        initButtons();
        addListeners();

        this.stage = new Stage(new ScreenViewport());
        stage.addActor(upgradeButtonTower);
        stage.addActor(upgradeButtonTurret);
        stage.addActor(upgradeButtonTurret2);
        stage.addActor(buildButtonTurret);
        stage.addActor(respawnPlayerButton);
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

        Texture texturerespawnPlayer = new Texture("badlogic.jpg");
        this.respawnPlayerButton = new ImageButton((getTxrDrawable(texturerespawnPlayer)));
        this.respawnPlayerButton.setSize(70,40);
        this.respawnPlayerButton.setPosition(200, 40);
    }

    /*
    Adds listeners to the buttons that informs controller of specific inputs by the user.
     */
    private void addListeners(){
        this.upgradeButtonTower.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                controller.upgradeTower();
            }
        });
        this.upgradeButtonTurret.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                controller.upgradeTurret(1);
            }
        });
        this.upgradeButtonTurret2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){
                    controller.upgradeTurret(2);
                }
        });
        this.buildButtonTurret.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                controller.buildTurret();
            }
        });
        this.respawnPlayerButton.addListener((ClickListener) new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playerSpawnController.respawn();
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

     /**
      * Renders buttons. Begins with updating visibility of buttons.
      */
    @Override
    public void render() {
        updateButtonVisibility();
        stage.draw();
    }

     /**
      * Disposes any buttons rendered.
      */
    @Override
    public void dispose() {
        stage.dispose();
    }

     @Override
     public void IsGamePaused(boolean isGamePaused) {
        if (!isGamePaused){
            addListeners();
            this.stage = new Stage(new ScreenViewport());
            stage.addActor(upgradeButtonTower);
            stage.addActor(upgradeButtonTurret);
            stage.addActor(upgradeButtonTurret2);
            stage.addActor(buildButtonTurret);
            stage.addActor(respawnPlayerButton);
            Gdx.input.setInputProcessor(stage);
        }
     }
 }
