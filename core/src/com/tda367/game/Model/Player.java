package Model;
import Interfaces.IObservers;
import Interfaces.IPaus;
import Interfaces.IReSpawnable;


public class Player extends Entity implements IObservers, IPaus, IReSpawnable {
    private static int damage = 25;
    private static final float velocity = 7;
    private boolean isAttacking;
    private boolean isAbleToMoveRight;
    private boolean isAbleToMoveLeft;
    private long latestAttackTime;
    private final AttackHitbox attackHitbox;
    private int maxHealth;
    private double timeAtDeath;
    private GameTimer gameTimer;
    private boolean isGamePaused = false;
    private MessageSender messageSender;

    /**
     * When creating a player it should have four parameters which will define
     * it.
     *  @param positionX represents the player's position on the x-axis
     *  @param positionY represents the player's position on the y-axis
     *  @param entityWidth represents the player's
     *  @param entityHeight represents the player's position on the y-axis
     */

    public Player(float positionX, float positionY, float entityWidth, float entityHeight, int health){
        super(positionX, positionY, entityWidth, entityHeight, health);
        isAbleToMoveLeft = true;
        isAbleToMoveRight = true;
        isAttacking  = true;
        attackHitbox = new AttackHitbox(positionX+width,positionY);
        maxHealth = health;
        gameTimer = GameTimer.GetInstance();
        messageSender = MessageSender.GetInstance();
    }

    /**
     * The getAttackHitbox() method gets a hitbox for a player
     * @return an attackHitbox
     */

    public AttackHitbox getAttackHitbox() {
        return attackHitbox;
    }

    /**
     * The moveLeft() method is allowing the character to move to the right side,
     * should also be updating the healthBar's position.
     */
    public void moveLeft(){
        if(isAbleToMoveLeft) {
            positionX -= velocity;
            attackHitbox.setX(positionX);
            updateHealthBar();
        }
    }

    /**
     * The moveRight() method is allowing the character to move to the right side,
     * should also be updating the healthbar's position.
     */
    public void moveRight(){
        if(isAbleToMoveRight){
            positionX += velocity;
            attackHitbox.setX(positionX);
            updateHealthBar();
        }
    }


    /**
     * The setter enables the player to move right
     * @param ableToMoveRight is a boolean to allow the player move right.
     * @return ableToMoveRight
     */
    public boolean setAbleToMoveRight(boolean ableToMoveRight) {
        isAbleToMoveRight = ableToMoveRight;
        return ableToMoveRight;
    }


    /**
     * The setter enables the player to move left.
     * @param ableToMoveLeft is a boolean to allow the player move left.
     * @return ableToMoveLeft
     */
    public boolean setAbleToMoveLeft(boolean ableToMoveLeft) {
        isAbleToMoveLeft = ableToMoveLeft;
        return ableToMoveLeft;
    }

    /**
     * The method decrement player's health depending on the input of damage.
     * @param damage is the input for dealing damage
     */
    public void takeDamage(int damage){
        if (!isGamePaused) {
            health -= damage;
            updateHealthBar();
            if (health <= 0) {
                playerDead();
            }
        }
    }

    private void playerDead(){
        if (!isDead) {
            timeAtDeath = GameTimer.GetInstance().GetTime();
            isDead = true;
        }
    }

    /**
     * The playerAttack-method enables the player to deal damage within 1 seconds intervals.
     * @param enemy is a parameter of the class Entity.
     */
    public void playerAttack(Entity enemy){
        long currentAttackTime = System.currentTimeMillis();
        long minIntervalbetweenAttack = 1000;
        if(isAttacking) {
            if (currentAttackTime > latestAttackTime + minIntervalbetweenAttack) {
                enemy.takeDamage(damage);
                latestAttackTime = currentAttackTime;
            }
        }
    }


    /**
     * Updates the current state of the player
     * @param action determines which state the player is taking.
     */
    private void updateState(ActionEnum action) {
        this.state = action;
    }

    /**
     * The method checks which method to use whenever an action is called.
     * @param action uses different methods depending on the action.
     */
    @Override
    public void actionHandle(ActionEnum action) {
        if (!isGamePaused) {
            updateState(action);
            if (action == ActionEnum.LEFT) {
                moveLeft();
                isAttacking = false;
            }
            if (action == ActionEnum.RIGHT) {
                moveRight();
                isAttacking = false;
            }
            if (action == ActionEnum.ATTACKING) {
                isAttacking = true;
            } else if (action == ActionEnum.DYING) {
                playerDead();
                isAttacking = false;
            }
        }
    }

    /**
     * Checks if the player is able to respawn
     * @param respawnColdown is the time it takes to respawn
     * @return true if the player is dead and the time is less than respawnCooldown
     */
    public boolean canRespawn(double respawnColdown) {
        if (isDead && gameTimer.GetTime() - timeAtDeath > respawnColdown) {
            return true;
        }
        else if (isDead) {
            messageSender.sendMessage(String.valueOf((int)(respawnColdown - (gameTimer.GetTime() - timeAtDeath))) + "seconds until respawn is available");
        }
        else {
            messageSender.sendMessage("Player is not dead");
        }
        return false;
    }

    /**
     * When respawning the health goes back to maxHealth, the player's boolean check 'isDead' should
     * be false, and the updateHealthBar should reset.
     * @param respawnColdown player is able to respawn.
     */
    @Override
    public void respawn(double respawnColdown) {
        if (canRespawn(respawnColdown)){
            health = maxHealth;
            isDead = false;
            updateHealthBar();
            messageSender.sendMessage("Respawned");
        }
    }

    /**
     *
     * @param isGamePaused
     */
    @Override
    public void IsGamePaused(boolean isGamePaused) {
        this.isGamePaused = isGamePaused;
    }
}
