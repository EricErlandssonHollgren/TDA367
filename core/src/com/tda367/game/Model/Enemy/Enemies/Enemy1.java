package Model.Enemy.Enemies;

import Interfaces.IEnemyAttack;
import Interfaces.IObject;
import Model.AttackFactory;
import Model.Enemy.Enemy;
import Model.FireAttack;

/**
 * First instance of an enemy to be rendered on the screen.
 * Values are currently placeholders, will change later.
 */
public class Enemy1 extends Enemy {
    public Enemy1(IObject fireAttack) {
        super(630, 100, 10, fireAttack);
    }
}
