package Model.Enemy;


import Model.Enemy.Enemies.Enemy1;
import Model.EntityHolder;

/**
 * A class for handling the task of creating different enemies. Is useful when different types of
 * enemies have to be created for the game.
 */
public class EnemyFactory {

    public static Enemy createEnemy1() {
        Enemy1 enemy1 = new Enemy1();
        //EntityHolder.getInstance().addEntity(enemy1);
        return enemy1;
    }

}
