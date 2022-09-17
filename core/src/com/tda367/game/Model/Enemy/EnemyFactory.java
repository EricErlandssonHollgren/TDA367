package Model.Enemy;


import Model.Enemy.Enemies.Enemy1;

/**
 *
 */
public class EnemyFactory {

    public static Enemy createEnemy1() {
        return new Enemy1();
    }
}
