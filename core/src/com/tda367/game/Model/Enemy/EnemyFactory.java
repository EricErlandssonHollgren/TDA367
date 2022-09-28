package Model.Enemy;


import Interfaces.IEnemy;
import Model.Enemy.Enemies.Enemy1;
import Model.Vector;

/**
 * A class for handling the task of creating different enemies. Is useful when different types of
 * enemies have to be created for the game. More methods will be added as new enemies have to be created.
 */
public class EnemyFactory {


    public static IEnemy createEnemy1(Vector x, Vector y) {
        return new Enemy1(x, y);
    }

}
