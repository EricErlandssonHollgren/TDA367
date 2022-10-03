package View;

import Interfaces.IView;
import Model.Tower;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class TowerView implements IView {

    Tower tower;
    Sprite towerSprite;
    private Batch batch;
    private Texture texture;

    /*
        A constructor for creating a view for the model of a Tower.
    */

    public TowerView(Tower tower){
        this.tower = tower;
        this.towerSprite = new Sprite();
        this.batch = new SpriteBatch();
        this.texture = new Texture("basicTowerSprite.png");
    }


    @Override
    public void render() {
        batch.begin();
        batch.draw(getTowerTexture(), towerSprite.getX(), towerSprite.getY());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
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
                return this.texture;
            }
        }
    }
}
