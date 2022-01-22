package com.withos.states;

public class UnoccupiedState implements IState{
    @Override
    public boolean isOccupied() {
        return false;
    }
}
