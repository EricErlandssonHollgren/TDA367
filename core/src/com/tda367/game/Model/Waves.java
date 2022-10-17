package Model;

import java.util.*;

public class Waves {

    private Queue<Enemy> queue = new LinkedList<>();
    private List<Enemy> currentEnemiesRendered = new ArrayList<>();
    private boolean wasRecentlySpawned = false;

    private List<Entity> enemiesInWave;

    public Waves() {
        this.enemiesInWave = new ArrayList<>();
    }

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

    public List<Entity> addEnemies2(){
        Enemy tempEnemy = new Enemy(630,100,10, AttackFactory.createFireFlame());
        for (int i = 0; i < 10; i++){
            EntityHolder.getInstance().addEntity(tempEnemy);
        }
        return EntityHolder.getInstance().getEntities();
    }


    /**
     * Takes the first enemy in the queue and returns it, as well as removes it from the queue.
     * @return the enemy that is first in line.
     *//*
    private Enemy getEnemyFromQueue() {
        //Enemy currentEnemy = addEnemies().poll();
        return Objects.requireNonNull(currentEnemy);
    }

/*
    /**
     * A method for rendering, and moving, an enemy across the screen every 30 seconds. After 30 seconds a new enemy is
     * to be spawned.
     * wasRecentlySpawned: A check for making sure only one enemy is being spawned every 30 seconds.
     */
    public List<Entity> getEnemiesToRender() {
        double timer = Math.ceil(GameTimer.GetInstance().GetTime());
        for (int i = 0 ; i <=10; i++) {
            if (timer % 10 == 0 && !wasRecentlySpawned) {
                Entity newEnemy = addEnemies2().get(i);
                //EntityHolder.getInstance().addEntity(newEnemy);
                wasRecentlySpawned = true;
                EntityHolder.getInstance().removeEntity(newEnemy);
            }
            if (timer % 10 == 9) {
                wasRecentlySpawned = false;
            }
        }
        //System.out.println(EntityHolder.getInstance().entities.size());
        return EntityHolder.getInstance().entities;
    }
}

