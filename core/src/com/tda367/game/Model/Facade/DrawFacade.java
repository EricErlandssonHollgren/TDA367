package Model.Facade;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DrawFacade {
    private SpriteBatch batch;
    private Sprite sprite;
    private Texture img;
    private ShapeRenderer shaperenderer;

    public DrawFacade(){
        batch = new SpriteBatch();
        shaperenderer = new ShapeRenderer();
    }

    public Texture getTexture() {
        return img;
    }
    public void setTexture(String path){
        img = new Texture(path);
    }
    public void drawObject(float x, float y, float imgWidth, float imgHeight){
        batch.begin();
        batch.draw(img, x,y,imgWidth,imgHeight);
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
