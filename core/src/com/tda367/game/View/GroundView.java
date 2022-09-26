package View;

import Interfaces.IView;
import Model.Block;
import Model.Ground;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
public class GroundView implements IView {
    private Ground ground;
    ShapeRenderer debugRenderer = new ShapeRenderer();

    public GroundView(){
        this.ground = new Ground();

    }
    @Override
    public void render() {
        debugRenderer.begin(ShapeType.Filled);
        for(Block block : ground.getBlocks()){
            Rectangle rect = block.getBounds();
            float x1 = block.getPosition().x + rect.x;
            float y1 = block.getPosition().y + rect.y;
            debugRenderer.setColor(new Color(Color.BROWN));
           debugRenderer.rect(x1,y1, rect.width, rect.height);
        }

        //debugRenderer.rect(15,1, 30, 30);
        debugRenderer.end();
    }

    @Override
    public void dispose() {

        debugRenderer.dispose();
    }
}
