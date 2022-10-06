package Model.Enemy;


import Interfaces.IEntity;

/**
 * A class for handling the task of creating different enemies. Is useful when different types of
 * enemies have to be created for the game.
 */
public class EnemyFactory {

    public static Enemy createEnemy(int worth, int HP, float x, float y) {
        return new Enemy(worth, HP, x,y);
    }

}
