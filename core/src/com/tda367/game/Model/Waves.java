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
    Queue<IEnemy> queue = new LinkedList<>();

    public Queue<IEnemy> addEnemies() {
        for (int i = 0; i < 10; i++){
            IEnemy tempEnemy = EnemyFactory.createEnemy1();
            queue.add(tempEnemy);
        }
        return queue;
    }

    /**
     * Returns (and afterwards removes) the first enemy in the queue if it is not null.
     */
    public IEnemy getEnemyFromQueue() {
        IEnemy currentEnemy = addEnemies().poll();
        return Objects.requireNonNull(currentEnemy);
    }

}

