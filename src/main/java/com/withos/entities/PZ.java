package com.withos.entities;

import com.withos.strategy.IStrategy;
import com.withos.strategy.MZStrategy;
import com.withos.strategy.PZStrategy;

import java.util.ArrayList;
import java.util.List;

public class PZ  extends Occurence{

    public PZ(double x, double y){
        super(x, y);
        super.setStrategy(new PZStrategy(this));
        super.setTrucks(new ArrayList<>());
    }

    @Override
    public IStrategy getStrategy() {
        return super.getStrategy();
    }

    @Override
    public int getTrucksNeeded() {
        return super.getTrucksNeeded();
    }

    @Override
    public void addTruck(Truck truck) {
        super.addTruck(truck);
    }

    @Override
    public void removeTruck(Truck truck) {
        super.removeTruck(truck);
    }

    @Override
    public List<Truck> getTrucks() {
        return super.getTrucks();
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }
}
