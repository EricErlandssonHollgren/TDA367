package Model;

import Interfaces.IEntity;
import Model.Enemy.Enemy;
import com.badlogic.gdx.math.Interpolation;

public class CollisionDetection {
    private EntityHolder posHandler;
    private Player player;
    private WorldBoundaries wb;
    private static CollisionDetection instance;
    private CollisionDetection(Player player){
        this.player = player;
        this.posHandler = EntityHolder.getInstance();
        this.wb = new WorldBoundaries();
    }

    public static CollisionDetection getInstance(Player player) {
        if(instance == null){
            instance = new CollisionDetection(player);
        }
        return instance;
    }


    /**
     * The method checks the collision between the player and the walls in the game. Enables the player to
     * either move right or left depending on which wall it collides with.
     */
    public void CheckCollisionPlayerAndBoundaries(){
        boolean ableToMoveRight = true;
        boolean ableToMoveLeft = true;

        for (Block block: wb.blocks) {
            if(player.getX() + player.getWidth() + player.getVelocity() > block.getX()
                    && player.getX() + player.getWidth() + player.getVelocity() < block.getWidth() + block.getX()
                    && player.getY() < block.getHeight() + block.getY() && block.getY() < player.getY()){
                ableToMoveRight = false;

            }

           if(player.getX() - player.getVelocity() > block.getX()
                   && player.getX() + player.getWidth() - player.getVelocity() < block.getWidth() + block.getX()
                   && player.getY() < block.getHeight() + block.getY() && block.getY() < player.getY()){
               ableToMoveLeft =false;

           }
        }
        player.setAbleToMoveRight(ableToMoveRight);
        player.setAbleToMoveLeft(ableToMoveLeft);

    }

    /**
     * The method checks the collision between the player and the enemy in the game. If the player is
     * colliding with an enemy it should be getting damage.
     */
    public void CheckCollisionPlayerAndEnemy(){
        for (IEntity entity: posHandler.entities) {
            if(entity instanceof Enemy){
                if((player.getX() + player.getWidth() >= entity.getX()) && (player.getX() <= entity.getX()+50)){
                    System.out.println(((Enemy) entity).getDamage());
                }
            }
        }
    }
}
