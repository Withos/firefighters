package com.withos.iterator;

import com.withos.entities.Occurence;

import java.util.List;

public class OccurancesIterator implements IIterator{

    private List<Occurence> occurences;
    int currentPos = 0;

    public OccurancesIterator(List<Occurence> occurences){
        this.occurences = occurences;
    }

    public List<Occurence> getOccurences() {
        return occurences;
    }

    @Override
    public boolean hasNext() {
        return this.occurences.size()<this.currentPos;
    }

    @Override
    public Occurence next() {
        if(!this.hasNext())
            return null;
        this.currentPos++;
        return occurences.get(this.currentPos-1);
    }
}
