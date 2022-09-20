package Model.Enemy;

/**
 * All methods and parameters that an Enemy might need.
 */


public abstract class Enemy {

    private int worth;
    private int HP;

    private float positionX;

    private float positionY;

    private String projectile;

    private String spritePath;

    /**
     *
     * @param worth = is what the enemy is "worth". int will be transferred to the player when the enemy has been killed
     * @param HP = every enemy has a number of "health points" that will decrease as it is being attacked.

     */
    public Enemy(int worth, int HP, String projectile, String spritePath, float positionX, float positionY) {
        this.worth = worth;
        this.HP = HP;
        this.projectile = projectile;
        this.spritePath = spritePath;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getWorth() {
        return worth;
    }

    public int getHP() {
        return HP;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }
}
