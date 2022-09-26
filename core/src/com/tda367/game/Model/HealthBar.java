package Model;


import com.badlogic.gdx.graphics.Texture;

public class HealthBar {
// stoppa in texurn här inne så det kan kalkuleras

    private float positionX;
    private float positionY;
    private static final float aboveY = 10;
    private float maxHealth;
    private float health;
    private Texture healthBarHolderImg;
    private Texture healthBarImg;


    public HealthBar(float x, float y, float health) {
        healthBarHolderImg = new Texture("grayhealthbar.png");
        healthBarImg = new Texture("healthBar/redhealthbar.png");
        positionX = x;
        positionY = y + aboveY;
        this.health = health;
    }

    public void updatePosition(float x, float y){
        positionX = x;
        positionY = y + aboveY;
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
