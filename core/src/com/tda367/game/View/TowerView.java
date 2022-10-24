package View;

import Interfaces.IView;
import View.Facade.DrawFacade;
import Model.Tower;


public class TowerView implements IView {

    private Tower tower;
    private DrawFacade drawFacade;
    private String texturePath;

    /**
     * A constructor for creating a view for the model of a Tower.
     * @param tower , the Tower object that the class views.
     */
    public TowerView(Tower tower){
        this.tower = tower;
        this.texturePath = "basicTowerSprite.png";
        this.drawFacade = new DrawFacade();
    }

    /**
     * Renders Tower. Begins with updating for proper tower texture.
     */
    @Override
    public void render() {
        updateTexturePath();
        drawFacade.setTexture(texturePath);
        drawFacade.drawObject(tower.getPositionX(),tower.getPositionY(),115,200);
    }

    /**
     * Disposes the rendered Tower.
     */
    @Override
    public void dispose() {
        drawFacade.dispose();
    }

    private void setTexturePath(String newTexturePath){
        this.texturePath = newTexturePath;
    }

    private void updateTexturePath(){
        if (this.tower.getLevel() > 1){
            if (this.tower.getTurrets().size() == 1){
                String newTexturePath = "Tower2_1Turret_Sprite.png";
                setTexturePath( newTexturePath);
            }
            else if (this.tower.getTurrets().size() > 1) {
                String newTexturePath = "Tower2_2Turret_Sprite.png";
                setTexturePath( newTexturePath);
            }
            else {
                String newTexturePath = "Tower2Sprite.png";
                setTexturePath( newTexturePath);
            }
        }

        else{
            if (this.tower.getTurrets().size() > 0){
                String newTexturePath = "Tower1_1Turret_Sprite.png";
                setTexturePath( newTexturePath);
            }
            else {
                String newTexturePath = "basicTowerSprite.png";
                setTexturePath( newTexturePath);
            }
        }
    }
}
