package Model;
import Interfaces.IBuild;
import Interfaces.IObservers;
import Interfaces.IUpgradeable;
import com.badlogic.gdx.Input;

import java.util.ArrayList;
/*
A player base
 */


public class Tower implements IBuild, IUpgradeable, IObservers {

    private int level;
    private double health;
    private final float positionX;
    private final float positionY;
    private int maxCapacity;
    private final ArrayList turrets;


    /*
    This creates a player base, which requires arguments for its health, location and maximum turrets capacity
     */
    public Tower(){
        this.level = 1;
        this.health = 500;
        positionX = 0;
        positionY = 100;
        this.maxCapacity = 1;
        this.turrets = new ArrayList<Turret>();
    }

    /*
        Builds a turret on the base if the base has available space for a turret
     */
    public void buildTurret(Turret turret){
        if (!this.isFull()){
            turrets.add(turret);
        }
    }

    /*
    Removes a turret from the base
     */
    public void sellTurret(Turret turret){
        if (this.turrets.contains(turret)){
            this.turrets.remove(turret);
        }
        else{
            throw new IllegalStateException("You don't have any turrets to be sold");
        }
    }


    /*
    Upgrades the level of the tower to have more health and more turret-capacity.
     */
    public void upgrade(){
        this.incrementLevel();
        this.incrementHealth();
        this.incrementMaxCapacity();

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

    /*
    Gets the current tower level
     */
    public int getLevel(){return level;}

    /*
    Gets the current tower health
     */
    public double getHealth(){return health;}

    /*
    Gets the current maximum turret capacity
     */
    public int getMaxCapacity(){return maxCapacity;}

    /*
    Gets the tower position x
     */
    public float getPositionX(){return positionX;}

    /*
    Gets the tower position y
     */
    public float getPositionY(){return positionY;}

    /*
    Gets the ArrayList of turrets that tower has.
    */
    public ArrayList<Turret> getTurrets() {return turrets;}

    /*
    Sets the level of the tower.
     */
    private void setLevel(int newLevel){this.level = newLevel;}

    /*
    Sets the health of the tower.
     */
    private void setHealth(double newHealth){this.health = newHealth;}

    /*
    Sets the maxCapacity of turrets for the tower.
     */
    private void setMaxCapacity(int newMaxCapacity){this.maxCapacity = newMaxCapacity;}

    /*
    Checks if the base is at max capacity
     */
    private boolean isFull(){
        return turrets.size() == getMaxCapacity();
    }


    @Override
    public void actionHandle(ActionEnum action) {
        if(action == ActionEnum.UPGRADE){
            upgrade();
        }
        if(action == ActionEnum.BUILD){
            buildTurret(new Turret());
        }

        if(action == ActionEnum.SELL){
            /*sellTurret();

             */
        }
        if(action == ActionEnum.UPGRADETURRET1){
            /*upgradeTurret(1);

             */
        }
        if(action == ActionEnum.UPGRADETURRET2){
            /*upgradeTurret(2);

             */
        }

    }
}