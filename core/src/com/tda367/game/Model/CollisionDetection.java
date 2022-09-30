package Model;

import Interfaces.IEntity;
import Model.Enemy.Enemy;

public class CollisionDetection {
    private Block block;
    private EntityHolder posHandler;
    private Player player;
    private static CollisionDetection instance;
    private CollisionDetection(Player player){
        this.player = player;
        this.posHandler = EntityHolder.getInstance();
    }

    public static CollisionDetection getInstance(Player player) {
        if(instance == null){
            instance = new CollisionDetection(player);
        }
        return instance;
    }

    public Block getBlock(){
        return block;
    }

    //every enemy checks how close it is to the player if it is within a range we start doing collisiondetection
    //
    public void CheckCollisionPlayerAndBoundaries(){
        int blockArea = getBlock().getHeight()*getBlock().getWidth();
        int playerArea = player.getWidth() * player.getHeight();
        //int velocity = (int)player.stopVelocity();

        if(player.getX() < playerArea || player.getX() > blockArea - playerArea){
             player.stopVelocity();
        }
        if(player.getY() < playerArea || player.getY() > blockArea - playerArea){
            player.stopVelocity();

        }

    }

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
