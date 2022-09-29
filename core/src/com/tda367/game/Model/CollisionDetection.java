package Model;

public class CollisionDetection {
    private Block block;
    private PositionsHandler posHandler;
    private boolean isCollided = false;
    private int width, height;
    private Player player;

    public CollisionDetection(int height, int width){
        this.height = height;
        this.width = width;
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

    }

}
