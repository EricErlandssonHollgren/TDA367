package Model;


public class HealthBar  {

    private float positionX;
    private float positionY;
    private float entityHeight;
    private float entityWidth;
    private float maxHealth;
    private float health;

    /**
     *
     * @param x determines its position of x.
     * @param y determines its position of y.
     * @param health determines its health.
     * @param entityWidth determines its entetys width.
     * @param entityHeight determines its entetys hieght.
     */
    public HealthBar(float x, float y, float health, float entityWidth, float entityHeight) {
        this.entityHeight = entityHeight;
        this.entityWidth = entityWidth;
        this.maxHealth = health;
        this.health = health;
        updatePosition(x,y);
    }

    /**
     * Updates the position of the healthhbar.
     * @param x determines the healthbars x position.
     * @param y determines the healthbars y position.
     */
    public void updatePosition(float x, float y){
        positionX = x + (entityWidth/2);
        positionY = y + entityHeight;
    }

    /**
     * Updates the halthbars health.
     * @param currentHeahlth determines the health.
     */
    public void updateHealth(int currentHeahlth) {
        health = currentHeahlth;
    }

    /**
     * Calculates and returns the percentage of the current health.
     * @return percentage
     */
    public float getHealthWidth(){
        return (health/maxHealth);
    }

    /**
     * Returns the current health.
     * @return health
     */
    public float getHealth() { return health; }

    /**
     * Returns the x cordinate.
     * @return positionX
     */
    public float getPositionX() {
        return positionX;
    }

    /**
     * Returns the y cordinate.
     * @return positionY
     */
    public float getPositionY() {
        return positionY;
    }

}
