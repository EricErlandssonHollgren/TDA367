package Model.Enemy;


import Interfaces.IEnemyAttack;
import Interfaces.IObject;
import Model.AttackFactory;
import Model.Enemy.Enemies.Enemy1;
import Model.EntityHolder;
import Model.FireAttack;
import View.FireView;

/**
 * A class for handling the task of creating different enemies. Is useful when different types of
 * enemies have to be created for the game.
 */
public class EnemyFactory {

    public static Enemy1 createEnemy1(IObject fire) {
        Enemy1 enemy1 = new Enemy1(fire);
        EntityHolder.getInstance().addEntity(enemy1);
        return enemy1;
    }

}
