package com.withos.entities;

import java.util.ArrayList;
import java.util.List;

public class Occurances {

    private List<Occurence> occurences;

    public Occurances(){
        this.occurences = new ArrayList<>();
    }

    public void addOccurence(Occurence occurence){
        this.occurences.add(occurence);
    }

    public List<Occurence> getOccurences() {
        return occurences;
    }

    public Occurence getLastOccurence(){
        if(occurences.size()>0)
            return occurences.get(occurences.size()-1);
        return null;
    }
}
