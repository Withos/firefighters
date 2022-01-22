package com.withos.entities;

import com.withos.states.UnoccupiedState;
import com.withos.strategy.IStrategy;

import java.util.List;

public class Occurence {

    private IStrategy strategy;
    private List<Truck> trucks;
    private final double x;
    private final double y;


    public Occurence(double x, double y){
        this.x=x;
        this.y=y;
    }

    public int getTrucksNeeded(){
        return this.strategy.getTrucksNeeded();
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public IStrategy getStrategy() {
        return strategy;
    }

    public void addTruck(Truck truck){
        trucks.add(truck);
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public void removeTruck(Truck truck){
        trucks.remove(truck);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void freeAllTrucks(){
        for (Truck truck : this.trucks){
            truck.setState(new UnoccupiedState());
        }
    }
}
