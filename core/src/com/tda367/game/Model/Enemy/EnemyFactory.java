package Model.Enemy;


import Interfaces.IEnemy;
import Model.Enemy.Enemies.Enemy1;
import Model.Facade.DrawFacade;
import Model.Vector;

/**
 * A class for handling the task of creating different enemies. Is useful when different types of
 * enemies have to be created for the game.
 */
public class EnemyFactory {


    public static IEnemy createEnemy1() {
        return new Enemy1();
    }

}
