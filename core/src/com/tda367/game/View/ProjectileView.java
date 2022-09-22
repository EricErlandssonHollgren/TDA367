package View;

import Interfaces.IView;
import Model.Projectile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ProjectileView implements IView{
    private Projectile projectile;
    private SpriteBatch batch;
    private Texture img;
    private Vector2 gravity;
    //everything should be a Ientity
    public ProjectileView(Projectile projectile, Vector2 gravity) {
        this.gravity = gravity;
        batch = new SpriteBatch();
        img = new Texture(Gdx.files.internal(projectile.getTexturePath()));
        this.projectile = projectile;

    }
    @Override
    public void render() {
        projectile.moveProjectile(gravity);
        batch.begin();
        batch.draw(img, projectile.getPosition().x,projectile.getPosition().y, (float) Math.ceil(img.getHeight()*0.2), (float) Math.ceil(img.getWidth()*0.25));
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

}
