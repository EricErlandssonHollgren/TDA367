package Model;

import Interfaces.IEnemy;
import Interfaces.IEntity;
import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;

import java.util.*;

public class Waves {
    /**
     * Adds enemies to a queue to be rendered
     * @param count: The number of enemies to be added to the queue
     * @return the queue
     */
    Queue<Enemy> queue = new LinkedList<>();
    List<Enemy> currentEnemiesRendered = new ArrayList<>();


    public Queue<Enemy> addEnemies() {
        for (int i = 0; i < 10; i++){
            Enemy tempEnemy = EnemyFactory.createEnemy1();
            queue.add(tempEnemy);
        }
        return queue;
    }

    /**
     * Returns (and afterwards removes) the first enemy in the queue if it is not null.
     */
    public Enemy getEnemyFromQueue() {
        Enemy currentEnemy = addEnemies().poll();
        return Objects.requireNonNull(currentEnemy);
    }

    /**
     * A method for rendering, and moving, an enemy across the screen every 40 seconds.
     */
    public List<Enemy> getEnemiesToRender() {
        double timer = Math.ceil(GameTimer.GetInstance().GetTime());
        System.out.println(Math.ceil(timer)%10)   ;
            if (timer % 10 == 0) {
            Enemy newEnemy = getEnemyFromQueue();
            currentEnemiesRendered.add(newEnemy);
        }
        //System.out.println(currentEnemiesRendered.size());
        return currentEnemiesRendered;
    }
}

