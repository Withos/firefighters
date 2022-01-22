package com.withos.strategy;

import com.withos.entities.Occurence;
import com.withos.observer.SKKM;

import java.util.concurrent.ThreadLocalRandom;

public class MZStrategy implements IStrategy{

    private int timeTo, timeAt = 0, timeFrom;
    private final int trucksNeeded;
    private final Occurence occurence;

    public MZStrategy(Occurence occurence){
        this.timeTo = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        this.timeFrom = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        this.trucksNeeded = 2;
        this.occurence = occurence;
    }

    @Override
    public int getTrucksNeeded() {
        return trucksNeeded;
    }

    @Override
    public void execute() {
        if(timeTo == 0){
            if(Math.random()<0.05) {
                System.out.println("Falszywy alarm");
            }
            else{
                this.timeAt = ThreadLocalRandom.current().nextInt(5, 25 + 1);
            }
        }
        if(timeTo < 1) {
            if (timeAt > 0) {
                timeAt--;
            } else if (timeFrom == 0) {
                System.out.println(trucksNeeded + " Pojazdy wrocily do jednostki " + this.occurence.getTrucks().get(0).getUnit().getName());
                this.occurence.freeAllTrucks();
                SKKM.getInstance().getOngoingOcurrences().remove(this.occurence);
            } else {
                timeFrom--;
            }
        }
        timeTo--;
    }
}
