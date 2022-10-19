package Model.Facade;

import Model.GameTimer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class AnimationFacade {
    private SpriteBatch batch;
    private Texture img;
    private ShapeRenderer shaperenderer;
    private double elapsedTime;

    public AnimationFacade(String texturePath){
        batch = new SpriteBatch();
        img = new Texture(texturePath);
        shaperenderer = new ShapeRenderer();
    }

    public Texture getTexture() {
        return img;
    }

    public AnimationFacade(){
        batch = new SpriteBatch();
        shaperenderer = new ShapeRenderer();
    }

    public void drawAnimation(Animation animation,float x, float y, float imgWidth, float imgHeight){
        elapsedTime = GameTimer.GetInstance().GetTime();
        batch.begin();
        batch.draw((TextureRegion) animation.getKeyFrame((float) elapsedTime, true),x ,y ,imgWidth , imgHeight);
        batch.end();
    }

    public ShapeRenderer getShaperenderer() {
        return shaperenderer;
    }

    public void dispose(){
        batch.dispose();
        img.dispose();
    }
}
