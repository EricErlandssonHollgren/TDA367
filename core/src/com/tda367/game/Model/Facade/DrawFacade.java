package Model.Facade;

import Model.GameTimer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class DrawFacade {
    private SpriteBatch batch;
    private Sprite sprite;
    private Texture img;
    private String texturePath;
    private ShapeRenderer shaperenderer;
    private double elapsedTime;
    private BitmapFont font;
    private boolean showTextureRegion = true;

    public DrawFacade(){
        batch = new SpriteBatch();
        shaperenderer = new ShapeRenderer();
        this.font = new BitmapFont();

    }

    public Texture getTexture() {
        return img;
    }
    public void setTexture(String path){
        img = new Texture(path);
    }
    public ShapeRenderer getShaperenderer() {
        return shaperenderer;
    }
    public void hideTexture(boolean b) { }


    public void drawObject(float x, float y, float imgWidth, float imgHeight){
        batch.begin();
        batch.draw(img, x,y,imgWidth,imgHeight);
        batch.end();
    }

    public void drawText(String str,float x, float y) {
        batch.begin();
        font.draw(batch,str, x,y);
        batch.end();
    }

    public void drawAnimation(Animation animation, float x, float y, float imgWidth, float imgHeight){
        elapsedTime = GameTimer.GetInstance().GetTime();
        batch.begin();
        batch.draw((TextureRegion) animation.getKeyFrame((float) elapsedTime, true),x ,y ,imgWidth , imgHeight);
        batch.end();
    }

    public void dispose(){
        batch.dispose();
        img.dispose();
    }
}
