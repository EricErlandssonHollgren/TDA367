package Model;

import Interfaces.IEnemyAttack;
import Interfaces.IProjectile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollisionDetection {
    private EntityHolder posHandler;
    private WorldBoundaries wb;

    private static CollisionDetection instance;

    private CollisionDetection() {
        this.posHandler = EntityHolder.getInstance();
        this.wb = new WorldBoundaries();
    }

    public static CollisionDetection getInstance() {
        if (instance == null) {
            instance = new CollisionDetection();
        }
        return instance;
    }

    /**
     * The method checks the collision between the player and the walls in the game. Enables the player to
     * either move right or left depending on which wall it collides with.
     */
    public void CheckCollisionPlayerNextStep(Player player) {
        boolean ableToMoveRight = true;
        boolean ableToMoveLeft = true;

        ableToMoveRight = !CheckCollisionPlayerWithRightBlock(wb.getBlocks().get(1), player);
        ableToMoveLeft = !CheckCollisionPlayerWithLeftBlock(wb.getBlocks().get(2), player);

        player.setAbleToMoveRight(ableToMoveRight);
        player.setAbleToMoveLeft(ableToMoveLeft);

    }

    /**
     * The method checks if the player is colliding with the left block
     * @param block to check collision with
     * @return if there will be a collision after the player's movement
     */
    public boolean CheckCollisionPlayerWithLeftBlock(Block block, Player player) {
        return player.getPosX() <= block.getX() + block.getWidth()
                && player.getPosY() < block.getHeight() + block.getY() && block.getY() < player.getPosY();
    }

    /**
     * The method checks if the player is colliding with the right block
     * @param block to check collision with
     * @return if there will be a collision after the player's movement
     */
    public boolean CheckCollisionPlayerWithRightBlock(Block block, Player player) {
        return player.getPosX() + player.getWidth() > block.getX()
                && player.getPosY() < block.getHeight() + block.getY() && block.getY() < player.getPosY();
    }

    /**
     * The method checks the collision between the player and the enemy in the game. If the player is
     * colliding with an enemy it will return a reference to that enemy along with the value true
     */
    public Map<Entity, Boolean> CheckCollisionPlayerAndEnemy(Player player) {
        Map<Entity, Boolean> collided = new HashMap<>();
        List<Entity> attackedEnemies = new ArrayList<>();
        for (Entity entity : posHandler.getEntities()) {
            if (entity instanceof Enemy) {
                if (EnemyAndPlayerColliding(entity, player)) {
                    collided.put(entity, true);
                    attackedEnemies.add(entity);
                }
                collided.put(entity, false);
            }
        }
        for (Entity e : attackedEnemies) {
            player.playerAttack(e);
        }
        return collided;
    }

    private boolean EnemyAndPlayerColliding(Entity entity, Player player) {
        return (player.getPosX() + player.getWidth() > entity.getPosX()) &&
                player.getPosX() <= entity.getWidth() + entity.getPosX();
    }

    /**
     * The method checks the collision between a tower and enemy. If the enemy is colliding with tower,
     * it will be removed from its list and tower will take damage.
     *
     * @param tower to check the collision with.
     */
    public void CheckCollisionTowerAndEnemy(Tower tower) {
        List<Entity> collisions = new ArrayList<>();
        for (Entity entity : posHandler.getEntities()) {
            if (entity instanceof Enemy) {
                if (TowerAndEnemyisColliding(tower, entity)) {
                    collisions.add(entity);
                }
            }
        }
        for (Entity e : collisions) {
            if(e instanceof  Enemy){
                tower.takeDamage(((Enemy) e).getDamage());
                posHandler.removeEntity(e);
            }
        }

    }


    private boolean TowerAndEnemyisColliding(Tower tower, Entity entity) {
        return tower.getPositionX() + tower.getWidth() > entity.getPosX() &&
                tower.getPositionX() <= entity.getWidth() + entity.getPosX();
    }


    public void CheckCollisionTowerAndFireAttack(Tower tower) {
       List<IEnemyAttack> collisions = new ArrayList<>();
        for (IEnemyAttack enemyAttack : posHandler.getEnemyAttacks()) {
            if(TowerAndFireAttackisColliding(tower, enemyAttack)){
                collisions.add(enemyAttack);
                enemyAttack.fireAttackAtTower(tower);
            }
        }
        for (IEnemyAttack enemyAttack : collisions) {
            posHandler.removeFireAttack(enemyAttack);
        }
    }

    private boolean TowerAndFireAttackisColliding(Tower tower, IEnemyAttack enemyAttack){
        return tower.getPositionX() + tower.getWidth() > enemyAttack.getX() &&
                tower.getPositionX() <= enemyAttack.getX() + enemyAttack.getWidth();
    }


    /**
     * Checks if the player and Fire Attack is at the same position and therefore colliding.
     * @param player: The player which will take damage from the attacks.
     */
    public void checkCollisionPlayerAndFireAttack(Player player){
        for (IEnemyAttack enemyAttack : posHandler.getEnemyAttacks()) {
            if (PlayerAndFireAttackIsColliding(player, enemyAttack)) {
                System.out.println("Colliding");
                enemyAttack.fireAttackAtPlayer(player);
            }
        }
    }


    private boolean PlayerAndFireAttackIsColliding(Player player, IEnemyAttack enemyAttack) {
        return player.getPosX() + player.getWidth() > enemyAttack.getX() &&
                player.getPosX() <= enemyAttack.getX() + enemyAttack.getWidth();
    }

    /**
     * Checks if a player should deal damage to an enemy through its hitbox
     * @param player checks if an enemy is colliding with player's hitbox
     */
    public void CheckCollisionEnemyAndHitBox(Player player){
        List<Entity> collisions = new ArrayList<>();
        float[] attackEdges = player.getAttackHitbox().getEdges();
        for (Entity entity: posHandler.getEntities()) {
            if(entity instanceof Enemy){
                if((attackEdges[1] > entity.getPosX()) &&
                        attackEdges[0] <= entity.getWidth() + entity.getPosX()){
                    collisions.add(entity);
                }
            }
        }
        for (Entity e: collisions) {
            player.playerAttack(e);
        }
    }

    /**
     * The method checks collision between projectiles and enemies in the game. If an enemy is hit
     * it will return the enemy that is hit along with the projectile that hit
     */
    public Map<Entity,IProjectile> checkCollisionProjectileAndEnemy(){
        Map<Entity, IProjectile> collided = new HashMap<>();
        List<Entity> attackedEnemies = new ArrayList<>();
        for (IProjectile projectile: posHandler.getProjectiles()) {
            for(Entity entity : posHandler.getEntities()) {
                if(entity instanceof Enemy){
                    if(isColliding(entity,projectile)){
                        attackedEnemies.add(entity);
                        collided.put(entity,projectile);

                    }

                }


            }
            for (Entity e: attackedEnemies) {
                projectile.projectileAttack(e);
            }
        }
        return collided;
    }

    private boolean isColliding(Entity entity, IProjectile projectile){
        if((projectile.getX() + projectile.getRadius()*2 >= entity.getPosX()) && (projectile.getX() <= entity.getPosX()+ entity.getHeight())){
            return (projectile.getY() + 2*projectile.getRadius() >= entity.getPosY()) && (projectile.getY() <= entity.getPosY()+ entity.getWidth());
        }
        return false;
    }

    /**
     * Checks the collision between the projectiles and the ground.
     * @return a list of collisions.
     */
    public List<IProjectile> checkCollisionProjectileGround(){
        List<IProjectile> collisions = new ArrayList<>();
        for (IProjectile p : posHandler.getProjectiles()){
            if(p.getY() <= wb.getBlocks().get(0).getY()+wb.getBlocks().get(0).getHeight()){
                collisions.add(p);
            }
        }
        return collisions;
    }
}
