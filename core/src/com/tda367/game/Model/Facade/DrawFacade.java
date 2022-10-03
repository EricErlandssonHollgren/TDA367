package Model.Facade;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DrawFacade {
    private SpriteBatch batch;
    private Texture img;

    public DrawFacade(String texturePath){
        batch = new SpriteBatch();
        img = new Texture(texturePath);
    }
    public void drawObject(float x, float y, float imgWidth, float imgHeight){
        batch.begin();
        batch.draw(img, x,y,imgWidth,imgHeight);
        batch.end();
    }

    public void dispose(){
        batch.dispose();
        img.dispose();
    }
}
