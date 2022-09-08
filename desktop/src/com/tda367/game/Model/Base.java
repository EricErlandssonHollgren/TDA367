package com.tda367.game.Model;

/*
A player base
 */

import java.util.ArrayList;

public class Base<T extends Turret>{

    private int health;
    private double position;
    private int max_capacity;
    private ArrayList<T> turrets;


    /*
    This creates a player base, which requires arguments for its health, location and maximum turrets capacity
     */
    public Base(int health, double position, int max_capacity){
        this.health = health;
        this.position = position;
        this.max_capacity = max_capacity;
        turrets = new ArrayList<>();
    }

    /*
    Gets the current base health
     */
    private int getHealth(){
        return health;
    }

    /*
    Gets the current maximum turret capacity
     */
    private int getMax_capacity(){
        return max_capacity;
    }
    /*
    Gets the base position
     */
    private double getPosition(){
        return position;
    }







}
