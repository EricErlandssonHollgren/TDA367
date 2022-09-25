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
    private OrthographicCamera camera;


    public GroundView(){
        this.ground = new Ground();
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.camera.position.set(5, 3.5f,0);
        this.camera.update();

    }
    @Override
    public void render() {
        debugRenderer.begin(ShapeType.Filled);
        debugRenderer.setProjectionMatrix(camera.combined);
        for(Block block : ground.getBlocks()){
            Rectangle rect = block.getBounds();
            float x1 = block.getPosition().x + rect.x;
            float y1 = block.getPosition().y + rect.y;
            debugRenderer.setColor(new Color(Color.RED));
            debugRenderer.rect(x1,y1, rect.width, rect.height);
        }

        //debugRenderer.rect(15,30, 30, 30);
        debugRenderer.end();
    }

    @Override
    public void dispose() {

        debugRenderer.dispose();
    }
}
