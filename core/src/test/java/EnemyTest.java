import Interfaces.IEnemyAttack;
import Model.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for making sure the enemy is in the right position on the screen as well is rendering as expected
 */

public class EnemyTest {
    Enemy enemy = new Enemy(630,100,10,AttackFactory.createFireFlame(630,100),125);
    Waves wave = new Waves();

    GameTimer timer = GameTimer.GetInstance();

    /**
     * Checks if the enemy is being rendered at the right position on the screen.
     * The actual values are taken from WorldBoundaries and in which position the walls and ground are created
     */
    @Test
    public void testPosition() {
        assertEquals(enemy.getPosX(), 630);
        assertEquals(enemy.getPosY(), 100);
    }

    /**
     * Checks if the enemy is moving from right to left along the X-axis on the screen by comparing its previous
     * position to the current one.
     */
    @Test
    public void testMovementX() {
        float posX = enemy.getPosX();
        enemy.moveEnemy();
        assertTrue(enemy.getPosX() < posX);
    }


    /**
     * Checks if the enemy is not moving in the Y-direction and therefore is staying on the "ground".
     */
    @Test
    public void testMovementY() {
        float posY = enemy.getPosY();
        enemy.moveEnemy();
        assertEquals(enemy.getPosY(), posY);
    }

    /**
     * Checks so that the number of enemies added to a wave is correct.
     */
    @Test
    public void testNumberOfEnemiesInQueue() {
        assertEquals(wave.getQueue().size(), 10);
    }

    @Test
    public void testEnemyAttack() {
        assertTrue(enemy.getEnemyAttack() instanceof FireAttack);
    }

    @Test
    public void testEnemiesToRender() {
        double nrOfEnemiesAtStart = EntityHolder.getInstance().getEntities().size();
        timer.resetTimer();
        wave.getEnemiesToRender();
        timer.UpdateTime(10);
        double nrOfEnemiesAtEnd =  EntityHolder.getInstance().getEntities().size();
        assertTrue(nrOfEnemiesAtStart < nrOfEnemiesAtEnd);
    }
    @Test
    public void enemyTakeDamage(){
        int initialHealth = enemy.getHealth();
        enemy.takeDamage(20);
        int newHealth = enemy.getHealth();

        assertTrue(initialHealth > newHealth);

    }

    @Test
    public void EnemyIsDead() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
       EntityHolder.getInstance().addEntity(enemy);
       EntityHolder.getInstance().addFireAttack(enemy.getEnemyAttack());
       PointHandler.addPoints(20);
       Goldhandler.addGold(20);

       int initialsizeOfEnemies = EntityHolder.getInstance().getEntities().size();
       int initialsizeOfAttack = EntityHolder.getInstance().getEnemyAttacks().size();
       int initialPoints = PointHandler.getPoints();
       int initialGold = Goldhandler.getGold();


       testPrivateMethodUsingReflection();
       int enemiesAfter = EntityHolder.getInstance().getEntities().size();
       int attackAfter = EntityHolder.getInstance().getEnemyAttacks().size();
       int pointsIsAdded = PointHandler.getPoints();
       int goldIsAdded = Goldhandler.getGold();


        assertTrue(initialsizeOfEnemies > enemiesAfter);
        assertTrue(initialsizeOfAttack > attackAfter);
        assertTrue(initialPoints < pointsIsAdded);
        assertTrue(initialGold < goldIsAdded);
    }


    public void testPrivateMethodUsingReflection() throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = Enemy.class.getDeclaredMethod("enemyDead");
        method.setAccessible(true);
        method.invoke(enemy);
    }

    @Test
    public void enemyDead(){
        enemy.takeDamage(125);
        assertTrue(enemy.isdead());
    }

    @Test
    public void ClearEntityHolder() {
        EntityHolder entityHolder = EntityHolder.getInstance();
        entityHolder.addEntity(new Player(10,10,10,10,10));
        int count = entityHolder.getEntities().size();
        entityHolder.clearAll();
        assertFalse(entityHolder.getEntities().size() == count);
    }

}