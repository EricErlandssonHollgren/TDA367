package Model.Enemy.Enemies;
import Interfaces.IObservers;
import Model.ActionEnum;
import Model.AttackFactory;
import Model.Enemy.Enemy;

/**
 * First instance of an enemy to be rendered on the screen.
 * Values are currently placeholders, will change later.
 */
public class Enemy1 extends Enemy{
    public Enemy1() {
        super(630F, 100F, 10,  AttackFactory.createFireFlame());
    }

}
