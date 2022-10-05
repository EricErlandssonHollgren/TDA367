package Model;

import Interfaces.IEntity;
import Model.Enemy.EnemyFactory;

import java.util.*;

public class Waves {

    /**
     * Adds enemies to a queue to be rendered
     * //@param count: The number of enemies to be added to the queue
     * @return the queue
     */
    Queue<IEntity> queue = new LinkedList<>();

    public Queue<IEntity> addEnemies() {
       for (int i = 0; i <= 10; i++) {
           queue.add(EnemyFactory.createEnemy1(300+i*10, 100));

       }
        return queue;
    }

    /**
     * Returns (and afterwards removes) the first enemy in the queue if it is not null.
     */
    public IEntity getEnemyFromQueue() {
        //Queue<IEnemy> enemies = addEnemies();
        IEntity currentEnemy = addEnemies().poll();
        return Objects.requireNonNull(currentEnemy);
    }

}
