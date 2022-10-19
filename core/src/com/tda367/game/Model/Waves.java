package Model;

import java.util.*;

public class Waves {

    private Queue<Enemy> queue;
    private boolean wasRecentlySpawned;

    private List<Entity> enemiesInWave;

    public Waves() {
        this.enemiesInWave = new ArrayList<>();
        this.wasRecentlySpawned = false;
        this.queue = new LinkedList<>();
        //addEnemies();
    }

    /**
     * Adds 10 enemies to a queue to later be used for rendering.
     * @return the queue containing all enemies in order of having been added.
     */
    public Queue<Enemy> addEnemies() {
        for (int i = 0; i < 10; i++){
            Enemy tempEnemy = new Enemy(630,100,10, AttackFactory.createFireFlame());
        }
        return queue;
    }

    public List<Entity> addEnemies2(){
        for (int i = 0; i < 10; i++){
            Enemy tempEnemy = new Enemy(630,100,10, AttackFactory.createFireFlame());
            EntityHolder.getInstance().addEntity(tempEnemy);
        }
        return EntityHolder.getInstance().getEntities();
    }


    /**
     * Takes the first enemy in the queue and returns it, as well as removes it from the queue.
     * @return the enemy that is first in line.
     */
    private Enemy getEnemyFromQueue() {
        return Objects.requireNonNull(addEnemies().poll());
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
                Entity newEnemy = getEnemyFromQueue();
                EntityHolder.getInstance().addEntity(newEnemy);
                wasRecentlySpawned = true;
                System.out.println(queue.size());
            }
            if (timer % 3 == 2) {
                wasRecentlySpawned = false;
            }
        }
        return EntityHolder.getInstance().entities;
    }
}

