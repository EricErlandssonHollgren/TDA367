package Model;


public class HealthBar  {

    private float positionX;
    private float positionY;
    private float entityHeight = 20;
    private float entityWidth = 20;
    private float maxHealth;
    private float health;

    public HealthBar(float x, float y, float health) {
        positionX = x + entityWidth/2;
        positionY = y + entityHeight;
        this.maxHealth = health;
        this.health = 80;
    }

    public void updatePosition(float x, float y){
        positionX = x + (entityWidth/2);
        positionY = y + entityHeight;
    }

    public void updateEntitySize(float entityWidth, float entityHeight) {
        this.entityWidth = entityWidth;
        this.entityHeight = entityHeight;
    }

    public void updateHealth(int currentHeahlth) {
        health = currentHeahlth;
    }

    public float getHealthWidth(){
        return (health/maxHealth);
    }

    public float getHealth() { return health; }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }

}