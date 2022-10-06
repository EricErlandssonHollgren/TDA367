package Model.Enemy;

import Interfaces.IEnemySubscriber;
import Interfaces.IEntity;
import Model.GameTimer;
import Model.Waves;

import java.util.ArrayList;
import java.util.List;

/**
 * All methods and parameters that an Enemy might need.
 */


public class Enemy implements IEntity {

    private int worth;
    private int HP;

    private float positionX;

    private float positionY;

    private List<IEnemySubscriber> subscribers = new ArrayList<>();
    List<Enemy> currentEnemiesRendered = new ArrayList<>();

    private Waves wave;


    /**
     *
     * @param worth = is what the enemy is "worth". int will be transferred to the player when the enemy has been killed
     * @param HP = every enemy has a number of "health points" that will decrease as it is being attacked.

     */
    public Enemy(int worth, int HP, float positionX, float positionY) {
        this.worth = worth;
        this.HP = HP;
        this.positionX = positionX;
        this.positionY = positionY;
        this.wave = new Waves();

    }

    public int getWorth() {
        return worth;
    }

    public int getHP() {
        return HP;
    }


    @Override
    public float getX() {
        return positionX;
    }

    @Override
    public float getY() {
        return positionY;
    }

    public void moveEnemy() {
        double speed = 0.5;
        positionX -= speed;
        for (IEnemySubscriber enemySubscriber : subscribers){
            enemySubscriber.updatePosition(positionX, positionY);
        }
    }

    public void positionSubscriber(IEnemySubscriber subscriber){
        subscribers.add(subscriber);
        subscriber.updatePosition(positionX,positionY);
    }

    public List<Enemy> getEnemiesToRender() {
        double timer = GameTimer.GetInstance().GetTime();
        if (Math.ceil(timer) % 10 == 0) {
            Enemy newEnemy = wave.getEnemyFromQueue();
            currentEnemiesRendered.add(newEnemy);
        }
        System.out.println(currentEnemiesRendered.size());
        return currentEnemiesRendered;
    }

/*
    public void renderEnemy() {
        getEnemiesToRender();
        for (Enemy enemy: currentEnemiesRendered) {
            float imgWidth = (float) Math.ceil(img.getWidth()*0.25);
            float imgHeight = (float) Math.ceil(img.getHeight()*0.15);
            enemy.move();
            drawFacade.drawObject(enemy.getX(), enemy.getY(), imgWidth, imgHeight);
        }
    }*/
}
