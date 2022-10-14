package Model;

import Model.Enemy.Enemy;
import Model.Enemy.EnemyFactory;

import java.util.*;

public class Waves {

    Queue<Enemy> queue = new LinkedList<>();
    List<Enemy> currentEnemiesRendered = new ArrayList<>();
    private boolean wasRecentlySpawned = false;

    /**
     * Adds 10 enemies to a queue to later be used for rendering.
     * @return the queue containing all enemies in order of having been added.
     */
    public Queue<Enemy> addEnemies() {
        for (int i = 0; i < 10; i++){
            Enemy tempEnemy = EnemyFactory.createEnemy1();
            queue.add(tempEnemy);
        }
        return queue;
    }

    /**
     * Takes the first enemy in the queue and returns it, as well as removes it from the queue.
     * @return the enemy that is first in line.
     */
    public Enemy getEnemyFromQueue() {
        Enemy currentEnemy = addEnemies().poll();
        return Objects.requireNonNull(currentEnemy);
    }

    /**
     * A method for rendering, and moving, an enemy across the screen every 30 seconds. After 30 seconds a new enemy is
     * to be spawned.
     * wasRecentlySpawned: A check for making sure only one enemy is being spawned every 30 seconds.
     */
    public List<Enemy> getEnemiesToRender() {
        double timer = Math.ceil(GameTimer.GetInstance().GetTime() );
        if (timer % 30 == 0 && !wasRecentlySpawned) {
            Enemy newEnemy = getEnemyFromQueue();
            currentEnemiesRendered.add(newEnemy);
            EntityHolder.getInstance().addEntity(newEnemy);
            wasRecentlySpawned = true;
        }
        if (timer % 30 == 9){
            wasRecentlySpawned = false;
        }
        return currentEnemiesRendered;
    }
}

