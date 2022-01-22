package com.withos.entities;

import com.withos.states.IState;
import com.withos.states.UnoccupiedState;

public class Truck {
    private IState state;
    private final Unit unit;

    public Truck(Unit unit){
        this.state = new UnoccupiedState();
        this.unit = unit;
    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public Unit getUnit() {
        return unit;
    }
}
