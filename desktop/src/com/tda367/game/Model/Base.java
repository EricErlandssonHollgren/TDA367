package com.tda367.game.Model;

/*
A player base
 */

import com.tda367.game.Model.Interfaces.Build;

import java.util.ArrayList;

public class Base implements Build {

    private double health;
    private double position;
    private int max_capacity;
    private ArrayList turrets;


    /*
    This creates a player base, which requires arguments for its health, location and maximum turrets capacity
     */
    public Base(double health, double position, int max_capacity){
        this.health = health;
        this.position = position;
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
    Gets the base position
     */
    public double getPosition(){
        return position;
    }

    public ArrayList<Turret> getTurrets() {
        return turrets;
    }

    /*
        Builds a turret on the base if the base has available space for a turret
         */
    public void buildTurret(Turret turret){
        if (!this.isFull()){
            turrets.add(turret);
        }
        else{
            throw new IllegalStateException("There is no space for a Turret");
        }
    }

    /*
    Removes a turret from the base
     */
    public void sellTurret(Turret turret){
        if (this.turrets.contains(turret)){
            this.turrets.remove(turret);
        }
        else;
    }

    /*
    Checks if the base is at max capacity
     */
    private boolean isFull(){
        return turrets.size() == max_capacity;
    }








}
