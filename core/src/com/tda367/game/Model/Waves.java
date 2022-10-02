package Model;

import Interfaces.IEnemy;
import Model.Enemy.EnemyFactory;

import java.util.*;

public class Waves {
    /**
     * Adds enemies to a queue to be rendered
     * @param count: The number of enemies to be added to the queue
     * @return the queue
     */
    public Queue<IEnemy> addEnemies(int count) {
        Queue<IEnemy> queue = new LinkedList<>();
        for (int i = 0; i <= count; i++) {
            queue.add(EnemyFactory.createEnemy1(new Vector(1000,0), new Vector(0,0)));
        }
        return queue;
    }

    /**
     * Returns (and afterwards removes) the first enemy in the queue if it is not null.
     */
    public IEnemy getEnemyFromQueue() {
        Queue<IEnemy> enemies = addEnemies(10);
        IEnemy currentEnemy = enemies.poll();
        return Objects.requireNonNull(currentEnemy);
    }

}
