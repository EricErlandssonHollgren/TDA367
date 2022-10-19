package Model;

import java.util.*;

public class Waves {

    private Queue<Enemy> queue;
    private boolean wasRecentlySpawned;

    public Waves() {
        this.wasRecentlySpawned = false;
        this.queue = new LinkedList<>();
        addEnemies();
    }

    /**
     * Adds 10 enemies to a queue to later be used for rendering.
     * @return the queue containing all enemies in order of having been added.
     */
    public void addEnemies() {
        for (int i = 0; i < 10; i++){
            Enemy tempEnemy = new Enemy(630,100,10, AttackFactory.createFireFlame());
            queue.add(tempEnemy);
        }
    }

    /**
     * A method for rendering, and moving, an enemy across the screen every 30 seconds. After 30 seconds a new enemy is
     * to be spawned.
     * wasRecentlySpawned: A check for making sure only one enemy is being spawned every 30 seconds.
     */
    public List<Entity> getEnemiesToRender() {
        double timer = Math.ceil(GameTimer.GetInstance().GetTime());
        for (int i = 0; i <= 10; i++) {
            if (timer % 3 == 0 && !wasRecentlySpawned) {
                Entity newEnemy = queue.poll();
                EntityHolder.getInstance().addEntity(newEnemy);
                wasRecentlySpawned = true;
            }
            if (timer % 3 == 2) {
                wasRecentlySpawned = false;
            }
        }
        return EntityHolder.getInstance().entities;
    }

    /**
     * Getter for returning the queue.
     * @return the queue with all current enemies in wave.
     */
    public Queue<Enemy> getQueue() {
        return queue;
    }
}

