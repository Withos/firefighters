package com.withos.entities;

import com.withos.states.OccupiedState;

import java.util.ArrayList;
import java.util.List;

public class Unit implements IUnit{

    private final List<Truck> trucks;
    private final double x, y;
    private final String name;

    public Unit(double x,double y, String name){
        this.trucks = new ArrayList<Truck>();
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public List<Truck> getUnoccupiedTrucks(){
        List<Truck> unoccupiedTrucks = new ArrayList<>();
        for(Truck truck : this.trucks){
            if(!truck.getState().isOccupied())
                unoccupiedTrucks.add(truck);
        }
        return unoccupiedTrucks;
    }

    public void generateTrucks(int x){
        for (int i = 0; i<x; i++)
            this.trucks.add(new Truck(this));
    }

    public void addTruck(Truck truck){
        this.trucks.add(truck);
    }

    @Override
    public double update(double x, double y) {
        return Math.sqrt((x-this.x)*(x-this.x)+(y-this.y)*(y-this.y));
    }

    @Override
    public boolean update(Occurence occurence) {
        List<Truck> unoccupiedTrucks = this.getUnoccupiedTrucks();
        if (unoccupiedTrucks.size() >= occurence.getTrucksNeeded()){
            for ( int i = 0; i < occurence.getTrucksNeeded(); i++){
                Truck truck = unoccupiedTrucks.get(i);
                truck.setState(new OccupiedState());
                occurence.addTruck(truck);
            }
            return true;
        }
        return false;
    }
}
