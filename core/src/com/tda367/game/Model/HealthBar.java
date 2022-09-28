package Model;


import com.badlogic.gdx.graphics.Texture;

public class HealthBar {
// stoppa in texurn här inne så det kan kalkuleras

    private float positionX;
    private float positionY;
    private float entityHeight;
    private float entityWidth;
    private static final float aboveY = 10;
    private float maxHealth;
    private float health;
    private Texture healthBarHolderImg;
    private Texture healthBarImg;


    public HealthBar(float x, float y, float health, float entityHeight, float entityWidth) {
        healthBarHolderImg = new Texture("grayhealthbar.png");
        healthBarImg = new Texture("healthBar/redhealthbar.png");
        positionX = x + entityWidth/2;
        positionY = y + entityHeight;
        this.health = health;
        this.entityHeight = entityHeight;
        this.entityWidth = entityWidth;
    }

    public void updatePosition(float x, float y){
        positionX = x+(entityWidth/2);
        positionY = y + entityHeight;
    }

    public void updateHealth(int currentHeahlth) {
        health = currentHeahlth;
    }

    public double getHealthWidth(){
        return (healthBarImg.getWidth()*(0.8));
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }




}
