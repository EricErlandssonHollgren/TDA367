package View.Facade;

import Model.GameTimer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class DrawFacade {
    private SpriteBatch batch;
    private Texture img;
    private ShapeRenderer shaperenderer;
    private double elapsedTime;
    private BitmapFont font;

    /**
     * Constructor for the draw facade
     */
    public DrawFacade(){
        shaperenderer = new ShapeRenderer();
        this.font = new BitmapFont();
        batch = new SpriteBatch();
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

    /**
     * Draws the text on the screen.
     * @param str the text that is drawn.
     * @param x the x-position at which the text is rendered
     * @param y the y-position at which the text is rendered
     */
    public void drawText(String str,float x, float y) {
        batch.begin();
        font.draw(batch,str, x,y);
        batch.end();
    }

    /**
     * Draws the aniamtion on the screen.
     * @param animation the animation frames.
     * @param x the x-position at which the animation is rendered
     * @param y the y-position at which the animation is rendered
     * @param imgWidth the imgWidth of the animation to be rendered
     * @param imgHeight the imgHeight of the animation to be rendered
     */
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
        shaperenderer.dispose();
        batch.dispose();
        img.dispose();
    }

    /**
     * Returns the texture.
     * @return imgTexture
     */
    public Texture getTexture() {
        return img;
    }
}
