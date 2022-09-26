package Model.Enemy;


import Model.Enemy.Enemies.Enemy1;

/**
 * A class for handling the task of creating different enemies. Is useful when different types of
 * enemies have to be created for the game. More methods will be added as new enemies have to be created.
 */
public class EnemyFactory {

    public static Enemy createEnemy1() {
        return new Enemy1();
    }
}
