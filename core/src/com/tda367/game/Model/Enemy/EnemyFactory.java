package Model.Enemy;

import Model.Enemy.Enemies.Enemy1;
import Model.Entity;
import Model.EntityHolder;

/**
 * A class for handling the task of creating different enemies. Is useful when different types of
 * enemies have to be created for the game.
 */
public class EnemyFactory {

    public static Enemy1 createEnemy1() {
        return new Enemy1();
    }

}
