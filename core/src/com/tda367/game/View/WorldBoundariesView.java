package View;

import Interfaces.IView;
import Model.Block;
import View.Facade.DrawFacade;
import Model.WorldBoundaries;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WorldBoundariesView implements IView {
    private WorldBoundaries worldBoundaries;
    private DrawFacade drawFacade;

    /**
     * Constructor for the worldboundariesview
     * @param worldBoundaries reference to the worldboundaries object
     */
    public WorldBoundariesView(WorldBoundaries worldBoundaries){
        this.worldBoundaries = worldBoundaries;
        drawFacade = new DrawFacade();
    }
    @Override
    public void render() {
        drawFacade.getShaperenderer().begin(ShapeType.Filled);
        for(Block block : worldBoundaries.getBlocks()){
            float rectX = block.getX();
            float rectY = block.getY();
            drawFacade.getShaperenderer().setColor(new Color(Color.BROWN));
           drawFacade.getShaperenderer().rect(rectX,rectY, block.getWidth(), block.getHeight());
        }
        drawFacade.getShaperenderer().end();
    }

    @Override
    public void dispose() {

        drawFacade.dispose();
    }
}
