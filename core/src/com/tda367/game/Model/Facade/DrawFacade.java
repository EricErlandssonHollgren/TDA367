package Model.Facade;

import Model.Entity;
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
    private Texture img;
    private ShapeRenderer shaperenderer;
    private double elapsedTime;
    private BitmapFont font;
    private boolean showTextureRegion = true;

    /**
     * Constructor for the draw facade
     */
    public DrawFacade(){
        batch = new SpriteBatch();
        shaperenderer = new ShapeRenderer();
        this.font = new BitmapFont();

    }

    /**
     * Sets the image variable to a specific file path
     * @param path the image path
     */
    public void setTexture(String path){
        img = new Texture(path);
    }

    /**
     * Getter for getting the shape renderer
     * @return the shape renderer
     */
    public ShapeRenderer getShaperenderer() {
        return shaperenderer;
    }

    /**
     * Method for drawing an object on the screen
     * @param x the x-position at which the object is rendered
     * @param y the y-position at which the object is rendered
     * @param imgWidth the imgWidth of the object to be rendered
     * @param imgHeight the imgHeight of the object to be rendered
     */
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

    /**
     * Disposes the batch and image
     */
    public void dispose(){
        batch.dispose();
        img.dispose();
    }

    public Texture getTexture() {
        return img;
    }
}
