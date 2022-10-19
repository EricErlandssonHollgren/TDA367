package View;

import Interfaces.IView;
import Model.Facade.DrawFacade;
import Model.Tower;


public class TowerView implements IView {

    private Tower tower;
    private DrawFacade drawFacade;
    private String texturePath;

    /*
        A constructor for creating a view for the model of a Tower.
    */
    public TowerView(Tower tower){
        this.tower = tower;
        this.texturePath = "basicTowerSprite.png";
        drawFacade = new DrawFacade(texturePath);
    }


    @Override
    public void render() {
        updateTexturePath();
        this.drawFacade = new DrawFacade(texturePath);
        drawFacade.drawObject(tower.getPositionX(),tower.getPositionY(),115,200);
        System.out.println(tower.getHealth());
    }

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
