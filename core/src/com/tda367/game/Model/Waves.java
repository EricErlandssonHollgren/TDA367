package Model;

import Interfaces.IPaus;

import java.util.*;

public class Waves implements IPaus {

    private Queue<Enemy> queue;
    private boolean wasRecentlySpawned;
    private RoundHandler roundHandler;
    private GameTimer gameTimer;
    private boolean isGamePaused = false;

    public Waves() {
        gameTimer = GameTimer.GetInstance();
        roundHandler = new RoundHandler(gameTimer);
        wasRecentlySpawned = false;
        queue = new LinkedList<>();
        addEnemies();
    }

    /**
     * Adds 10 enemies to a queue to later be used for rendering.
     *
     */
    public void addEnemies() {
        for (int i = 0; i < 10; i++){
            Enemy tempEnemy = new Enemy(630,100,10, AttackFactory.createFireFlame(630,100), (int)Math.ceil(125*roundHandler.getMultiplier()));
            queue.add(tempEnemy);
        }
    }

    /**
     * A method for rendering, and moving, an enemy across the screen every 30 seconds. After 30 seconds a new enemy is
     * to be spawned.
     * wasRecentlySpawned: A check for making sure only one enemy is being spawned every 30 seconds.
     */
    public List<Entity> getEnemiesToRender() {
        if (!isGamePaused) {
            double timer = Math.ceil(gameTimer.GetTime());
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

    @Override
    public void IsGamePaused(boolean isGamePaused) {
        this.isGamePaused = isGamePaused;
    }
}

