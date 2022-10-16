package Model;

import java.util.*;

public class Waves {

    private Queue<Enemy> queue = new LinkedList<>();
    private List<Enemy> currentEnemiesRendered = new ArrayList<>();
    private boolean wasRecentlySpawned = false;

    /**
     * Adds 10 enemies to a queue to later be used for rendering.
     * @return the queue containing all enemies in order of having been added.
     */
    public Queue<Enemy> addEnemies() {
        for (int i = 0; i < 10; i++){
            Enemy tempEnemy = new Enemy(630,100,10, AttackFactory.createFireFlame());
            queue.add(tempEnemy);
        }
        return queue;
    }

    public Enemy getEnemyFromQueue(){
        System.out.println(addEnemies().size());
        Enemy tempEnemy = addEnemies().poll();
        return Objects.requireNonNull(tempEnemy);
    }

    /**
     * A method for rendering, and moving, an enemy across the screen every 30 seconds. After 30 seconds a new enemy is
     * to be spawned.
     * wasRecentlySpawned: A check for making sure only one enemy is being spawned every 30 seconds.
     */
    public List<Enemy> getEnemiesToRender() {
        double timer = Math.ceil(GameTimer.GetInstance().GetTime());
        if (timer % 10 == 0 && !wasRecentlySpawned) {
            Enemy newEnemy = getEnemyFromQueue();
            //System.out.println(addEnemies().size());
            currentEnemiesRendered.add(newEnemy);
            wasRecentlySpawned = true;
            EntityHolder.getInstance().addEntity(newEnemy);
        }
        if (timer % 10 == 9){
            wasRecentlySpawned = false;
        }
        return currentEnemiesRendered;
    }
}

