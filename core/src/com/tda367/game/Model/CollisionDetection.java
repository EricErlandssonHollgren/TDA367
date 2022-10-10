package Model;

import Interfaces.IObservers;
import Interfaces.IProjectile;
import Model.Enemy.Enemy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollisionDetection {
    private EntityHolder posHandler;
    private WorldBoundaries wb;
    private Tower tower;
    private List<IObservers> observers = new ArrayList<>();
    private static CollisionDetection instance;

    private CollisionDetection(){
        this.posHandler = EntityHolder.getInstance();
        this.wb = new WorldBoundaries();
    }

    public static CollisionDetection getInstance() {
        if(instance == null){
            instance = new CollisionDetection();
        }
        return instance;
    }

    public void addSubscribers(IObservers observer){
        observers.add(observer);
    }


    /**
     * The method checks the collision between the player and the walls in the game. Enables the player to
     * either move right or left depending on which wall it collides with.
     */
    public void CheckCollisionPlayerNextStep(Player player){
        boolean ableToMoveRight = true;
        boolean ableToMoveLeft = true;

        ableToMoveRight = !CheckCollisionPlayerwithRightBlock(wb.getBlocks().get(1),player);
        ableToMoveLeft = !CheckCollisionPlayerwithLeftBlock(wb.getBlocks().get(2),player);

        player.setAbleToMoveRight(ableToMoveRight);
        player.setAbleToMoveLeft(ableToMoveLeft);

    }

    /**
     * The method checks if the player is colliding with the left block
     * @param block to check collision with
     * @return if there will be a collision after the player's movement
     */
    public boolean CheckCollisionPlayerwithLeftBlock(Block block, Player player) {
        return player.getPosX() <= block.getX()+ block.getWidth()
                && player.getPosY() < block.getHeight() + block.getY() && block.getY() < player.getPosY();
    }

    /**
     * The method checks if the player is colliding with the right block
     * @param block to check collision with
     * @return if there will be a collision after the player's movement
     */
    public boolean CheckCollisionPlayerwithRightBlock(Block block, Player player) {
        return player.getPosX() + player.getWidth() > block.getX()
                && player.getPosY() < block.getHeight() + block.getY() && block.getY() < player.getPosY();
    }

    /**
     * The method checks the collision between the player and the enemy in the game. If the player is
     * colliding with an enemy it will return a referenece to that enemy along with the value true
     */
    public Map<Entity, Boolean> CheckCollisionPlayerAndEnemy(Player player){
        Map<Entity, Boolean> collisions = new HashMap<>();
        boolean ableToDoDamage = true;
        for (Entity entity: posHandler.entities) {
            if(entity instanceof Enemy){
                if((player.getPosX() + player.getWidth() > ((Enemy) entity).getX())){
                    collisions.put(entity,true);
                    player.collisionAttack(entity);
                    //TODO: Uppdatera attacken efter klockan. Förmodligen inte här
                }
                collisions.put(entity,false);
            }
        }
        return collisions;
    }

    /**
     * The method checks collision between projectiles and enemies in the game. If an enemy is hit
     * it will return the enemy that is hit along with the value true
     */
    public Map<Entity, Boolean> checkCollisionProjectileAndEnemy(){
        Map<Entity, Boolean> collided = new HashMap<>();
        for (IProjectile projectile: posHandler.projectiles) {
            for(Entity entity : posHandler.entities) {
                if(entity instanceof Enemy){
                    if((projectile.getX() + projectile.getRadius()*2 >= entity.getPosX()) && (projectile.getX() <= entity.getPosX()+50)){
                        if((projectile.getY() + 2*projectile.getRadius() >= entity.getPosY()) && (projectile.getY() <= entity.getPosY()+50)){
                            collided.put(entity,true);

                        }
                    }
                    collided.put(entity,false);
                }
            }
        }
        return collided;
    }

}
