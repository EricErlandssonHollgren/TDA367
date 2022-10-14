package Model.Facade;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class DrawFacade {
    private SpriteBatch batch;
    private Texture img;
    private ShapeRenderer shaperenderer;
    private BitmapFont font;

    public DrawFacade(String TexturePath){
        batch = new SpriteBatch();
        img = new Texture(TexturePath);
        shaperenderer = new ShapeRenderer();
        this.font = new BitmapFont();
    }

    public Texture getTexture() {
        return img;
    }

    public DrawFacade(){
        batch = new SpriteBatch();
        shaperenderer = new ShapeRenderer();
        this.font = new BitmapFont();

    }

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

    public ShapeRenderer getShaperenderer() {
        return shaperenderer;
    }

    public void dispose(){
        batch.dispose();
        img.dispose();
    }
}
