package View;

import Interfaces.IView;
import Model.Block;
import Model.Facade.DrawFacade;
import Model.WorldBoundaries;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WorldBoundariesView implements IView {
    private WorldBoundaries worldBoundaries;
    private DrawFacade drawFacade;

    public WorldBoundariesView(WorldBoundaries worldBoundaries){
        this.worldBoundaries = worldBoundaries;

    }
    @Override
    public void render() {
        drawFacade.getShaperenderer().begin(ShapeType.Filled);
        for(Block block : worldBoundaries.getBlocks()){
            int rectX = block.getX();
            int rectY = block.getY();
            drawFacade.getShaperenderer().setColor(new Color(Color.BROWN));
           drawFacade.getShaperenderer().rect(rectX,rectY, block.getWidth(), block.getHeight());
        }
        drawFacade.getShaperenderer().end();
    }

    @Override
    public void dispose() {

        drawFacade.getShaperenderer().dispose();
    }
}
