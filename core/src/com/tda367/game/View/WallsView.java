package View;

import Interfaces.IView;
import Model.Block;
import Model.Walls;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class WallsView implements IView {
    private Walls walls;
    ShapeRenderer debugRenderer = new ShapeRenderer();

    public WallsView(){
        this.walls = new Walls();

    }
    @Override
    public void render() {
        debugRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for(Block block : walls.getBlocks()){
            Rectangle rect = block.getBounds();
            float x1 = block.getPosition().x + rect.x;
            float y1 = block.getPosition().y + rect.y;
            debugRenderer.setColor(new Color(Color.BLUE));
            debugRenderer.rect(x1,y1, 10, Gdx.graphics.getHeight());
        }
        debugRenderer.end();
    }

    @Override
    public void dispose() {

        debugRenderer.dispose();
    }
}
