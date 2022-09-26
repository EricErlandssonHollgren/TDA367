package View;

import Interfaces.IView;
import Model.Enemy.Enemy;
import Model.HealthBar;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

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
        batch.draw(healthBarHolderImg, healthBar.getPositionX(), healthBar.getPositionY());
        batch.draw(healthBarImg, healthBar.getPositionX(), healthBar.getPositionY(), (float) healthBar.getHealthWidth(), healthBarImg.getHeight());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        healthBarHolderImg.dispose();
    }
}
