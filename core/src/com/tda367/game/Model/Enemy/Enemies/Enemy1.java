package Model.Enemy.Enemies;

import Model.Enemy.Enemy;

/**
 * First instance of an enemy to be rendered on the screen.
 * Values are currently placeholders, will change later.
 */
public class Enemy1 extends Enemy {

    private static final int worth = 5;
    private static int HP = 5;
    private static final float positionX = 780;
    private static final float positionY = 100;
    private static final int damage = 10;

    public Enemy1() {
        super(worth, HP, positionX, positionY, damage);
    }
}
