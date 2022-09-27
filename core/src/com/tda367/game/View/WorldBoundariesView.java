package View;

import Interfaces.IView;
import Model.Block;
import Model.WorldBoundaries;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WorldBoundariesView implements IView {
    private WorldBoundaries worldBoundaries;
    private ShapeRenderer debugRenderer = new ShapeRenderer();

    public WorldBoundariesView(){
        this.worldBoundaries = new WorldBoundaries();

    }
    @Override
    public void render() {
        debugRenderer.begin(ShapeType.Filled);
        for(Block block : worldBoundaries.getBlocks()){
            int rectX = block.getX();
            int rectY = block.getY();
            float x1 = block.getX() + rectX;
            float y1 = block.getY() + rectY;
            debugRenderer.setColor(new Color(Color.BROWN));
           debugRenderer.rect(x1,y1, block.getWidth(), block.getHeight());
        }
        debugRenderer.end();
    }

    @Override
    public void dispose() {

        debugRenderer.dispose();
    }
}
