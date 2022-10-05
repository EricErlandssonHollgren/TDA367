package Model.Enemy.Enemies;
import Interfaces.IEntitySubscriber;
import Model.Enemy.Enemy;
import java.util.ArrayList;
import java.util.List;

/**
 * First instance of an enemy to be rendered on the screen.
 * Values are currently placeholders, will change later.
 */
public class Enemy1 extends Enemy {
    public Enemy1(float x, float y) {
        super(5, 10, x, y);
    }
}
