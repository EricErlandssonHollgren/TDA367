package Model.Enemy;


import Interfaces.IEntity;
import Model.Enemy.Enemies.Enemy1;

/**
 * A class for handling the task of creating different enemies. Is useful when different types of
 * enemies have to be created for the game.
 */
public class EnemyFactory {


    public static Enemy createEnemy1(float x, float y) {
        return new Enemy1(x,y);
    }

}
