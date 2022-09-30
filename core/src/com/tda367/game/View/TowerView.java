package View;

import Interfaces.IView;
import Model.Tower.Tower;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class TowerView implements IView {

    Sprite towerSprite;
    private Batch batch;
    private Texture texture;

    /*
        A constructor for creating a view for the model of a Tower.
    */

    public TowerView(){
        this.towerSprite = new Sprite();
        this.batch = new SpriteBatch();
        this.texture = new Texture("basicTowerSprite.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 0);
        batch.begin();
        batch.draw(texture, towerSprite.getX(), towerSprite.getY());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
