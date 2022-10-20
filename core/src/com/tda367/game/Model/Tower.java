package Model;
import Interfaces.IBuild;
import Interfaces.IObservers;
import Interfaces.IUpgradeable;

import java.util.ArrayList;

public class Tower implements IBuild, IUpgradeable, IObservers {

    private int level;
    private double health;
    private final float positionX;
    private final float positionY;
    private final float width;
    private int maxCapacity;
    private final ArrayList turrets;
    private Goldhandler gold;


    /**
     * This creates a Tower, which requires arguments for its health, location and maximum turrets capacity.
     * @param gold , uses gold to check if conditions are met for different methods of Tower.
     */
    public Tower(Goldhandler gold){
        this.level = 1;
        this.health = 500;
        positionX = 0;
        positionY = 100;
        width = 100;
        this.maxCapacity = 1;
        this.turrets = new ArrayList<Turret>();
        this.gold = gold;
    }

    /**
     * Builds a Turret on the Tower if the Tower has available space for a Turret
     * @param turret , builds the Turret sent as argument to the method.
     */
    public void buildTurret(Turret turret){
        if (!this.isFull() && gold.getGold() >= 1000){
            turrets.add(turret);
            gold.handleRequest(new Request(HandlerItemDefiners.GOLD, -1000));
        }
    }

    /**
     * Upgrades a selected Turret.
     */
    public void upgradeTurret(int index){
        if(gold.getGold() >=1000){
            getTurrets().get(index).upgrade();
            gold.handleRequest(new Request(HandlerItemDefiners.GOLD, -1000));
        }
    }

    /**
     * Upgrades the level of the Tower to have more health and more turret-capacity.
     */
    public void upgrade(){
        if (gold.getGold() >= 3000) {
            this.incrementLevel();
            this.incrementHealth();
            this.incrementMaxCapacity();
            gold.handleRequest(new Request(HandlerItemDefiners.GOLD, -3000));
        }
    }

    /*
    Increments the level of the tower.
     */
    private void incrementLevel(){
        setLevel(getLevel() + 1);
    }

    /*
    Increments the health of the tower.
     */
    private void incrementHealth(){
        setHealth(getHealth() + (getLevel() * 100));
    }

    /*
    Increments the turret-capacity of the tower.
     */
    private void incrementMaxCapacity(){
        setMaxCapacity(getMaxCapacity() + 1);
    }

    /**
     * Gets the current Tower level
     */
    public int getLevel(){ return level;}

    /**
     * Gets the current Tower health
     */
    public double getHealth(){ return health;}

    /**
     * Gets the current maximum Turret capacity
     */
    public int getMaxCapacity(){ return maxCapacity;}

    /**
     * Gets the Tower position x
     */
    public float getPositionX(){ return positionX;}

    /**
     * Gets the Tower position y
     */
    public float getPositionY(){ return positionY;}

    /**
     * Gets the ArrayList of Turrets that Tower has.
     */
    public ArrayList<Turret> getTurrets() { return turrets;}

    /**
     * Should be getting the tower's width
     * @return tower's width
     */
    public float getWidth(){return width;}

    /*
    Sets the level of the Tower.
     */
    private void setLevel(int newLevel){ this.level = newLevel;}

    /*
    Sets the health of the Tower.
     */
    private void setHealth(double newHealth){ this.health = newHealth;}

    /*
    Sets the maxCapacity of Turrets for the Tower.
     */
    private void setMaxCapacity(int newMaxCapacity){ this.maxCapacity = newMaxCapacity;}

    /*
    Checks if the Tower is at max capacity.
     */
    private boolean isFull(){
        return turrets.size() == getMaxCapacity();
    }

    public void takeDamage(int damage){
        health -= damage;
        System.out.println(health);
        if(health <= 0){
            //TODO: Gameover.
        }
    }

    /**
     * Handles different tasks given by controller to update the state of Tower.
     * @param action , calls to different tasks depending on what action.
     */
    @Override
    public void actionHandle(ActionEnum action) {
        if(action == ActionEnum.UPGRADE){
            upgrade();
        }
        if(action == ActionEnum.BUILD){
            buildTurret(new Turret());
        }
        if(action == ActionEnum.UPGRADETURRET1){
            upgradeTurret(0);
        }
        if(action == ActionEnum.UPGRADETURRET2){
            upgradeTurret(1);
        }
    }
}
