package View;

import Interfaces.IView;
import Model.HealthBar;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HealthBarView implements IView {

    private HealthBar healthBar;
    private SpriteBatch batch;
    private Texture healthBarHolderImg;
    private Texture healthBarImg;

    public HealthBarView(HealthBar healthBar) {
        this.healthBar = healthBar;
        batch = new SpriteBatch();
        healthBarHolderImg = new Texture("grayhealthbar.png");
        healthBarImg = new Texture("healthBar/redhealthbar.png");
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(healthBarHolderImg, healthBar.getPositionX(), healthBar.getPositionY(), healthBarHolderImg.getWidth(), healthBarHolderImg.getHeight());
        batch.draw(healthBarImg, healthBar.getPositionX(), healthBar.getPositionY(), healthBarImg.getWidth() * healthBar.getHealthWidth(), healthBarImg.getHeight());
        batch.end();
    }



    @Override
    public void dispose() {
        batch.dispose();
        healthBarHolderImg.dispose();
    }
}
