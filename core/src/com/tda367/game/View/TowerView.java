package View;

import Interfaces.IView;
import Model.Facade.DrawFacade;
import Model.Tower;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class TowerView implements IView {

    private Tower tower;
    private DrawFacade drawFacade;
    /*
        A constructor for creating a view for the model of a Tower.
    */

    public TowerView(Tower tower){
        this.tower = tower;
        drawFacade = new DrawFacade("basicTowerSprite.png");
    }


    @Override
    public void render() {
        drawFacade.drawObject(tower.getPositionX(),tower.getPositionY(),115,200);
    }

    @Override
    public void dispose() {
        drawFacade.dispose();
    }

    private Texture getTowerTexture(){
        if (this.tower.getLevel() > 1){
            if (this.tower.getTurrets().size() == 1){
                return new Texture("Tower2_1Turret_Sprite.png");
            }
            else if (this.tower.getTurrets().size() > 1) {
                return new Texture("Tower2_2Turret_Sprite.png");
            }
            else {
                return new Texture("Tower2Sprite.png");
            }
        }

        else{
            if (this.tower.getTurrets().size() > 0){
                return new Texture("Tower1_1Turret_Sprite.png");
            }
            else {
                return new Texture("basicTowerSprite.png");
            }
        }
    }
}
