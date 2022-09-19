package Model;
import Interfaces.Build;

import java.util.ArrayList;
/*
A player base
 */


public class Base implements Build {

    private double health;
    private double positionX;
    private double positionY;
    private int max_capacity;
    private ArrayList turrets;


    /*
    This creates a player base, which requires arguments for its health, location and maximum turrets capacity
     */
    public Base(double health, double positionX, double positionY, int max_capacity){
        this.health = health;
        this.positionX = positionX;
        this.positionY = positionY;
        this.max_capacity = max_capacity;
        turrets = new ArrayList<Turret>();
    }

    /*
    Gets the current base health
     */
    public double getHealth(){

        return health;
    }

    /*
    Gets the current maximum turret capacity
     */
    public int getMax_capacity(){

        return max_capacity;
    }

    /*
    Gets the base position x
     */
    public double getPositionX(){

        return positionX;
    }

    /*
    Gets the base position y
     */
    public double getPositionY(){

        return positionY;
    }

    /*
    Gets the base position y
     */
    public ArrayList<Turret> getTurrets() {

        return turrets;
    }

    /*
        Builds a turret on the base if the base has available space for a turret
     */
    public void buildTurret(Turret turret){
        if (this.isFull()){
            throw new IllegalStateException("There is no space for a Turret");
        }
        else{
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
    Checks if the base is at max capacity
     */
    private boolean isFull(){
        return turrets.size() == max_capacity;
    }








}
