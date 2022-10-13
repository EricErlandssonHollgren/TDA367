package Model.Facade;

import Model.GameTimer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DrawFacade {
    private SpriteBatch batch;
    private Texture img;
    private String texturePath;
    private ShapeRenderer shaperenderer;
    private double elapsedTime;

    public DrawFacade(String texturePath){
        batch = new SpriteBatch();
        img = new Texture(texturePath);
        this.texturePath = texturePath;
        shaperenderer = new ShapeRenderer();
    }

    public Texture getTexture() {
        return img;
    }

    public DrawFacade(){
        batch = new SpriteBatch();
        shaperenderer = new ShapeRenderer();
    }

    public void drawObject(float x, float y, float imgWidth, float imgHeight){
        batch.begin();
        batch.draw(img, x,y,imgWidth,imgHeight);
        batch.end();
    }

    public void drawAnimation(Animation animation, float x, float y, float imgWidth, float imgHeight){
        elapsedTime = GameTimer.GetInstance().GetTime();
        batch.begin();
        batch.draw((TextureRegion) animation.getKeyFrame((float) elapsedTime, true),x ,y ,imgWidth , imgHeight);
        batch.end();
    }

    /*
    public void drawtext(float x, float y) {
        batch.begin();
        batch.draw(texturePath, x,y);
        batch.end();
    }
    
     */


    public ShapeRenderer getShaperenderer() {
        return shaperenderer;
    }

    public void dispose(){
        batch.dispose();
        img.dispose();
    }
}
