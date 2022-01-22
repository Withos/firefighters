package com.withos.observer;

import com.withos.entities.Occurence;
import com.withos.entities.Unit;
import com.withos.generator.OccurenceGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class SKKM {

    private final List<Unit> units;
    private final List<Occurence> occurances;
    private final List<Occurence> ongoingOcurrences;
    private final OccurenceGenerator generator;
    private static SKKM instance;


    private SKKM(){
        this.units = new ArrayList<Unit>();
        this.occurances = new ArrayList<>();
        this.generator = new OccurenceGenerator(occurances);
        this.ongoingOcurrences = new ArrayList<>();
    }

    public static SKKM getInstance(){
        if (instance == null){
            instance = new SKKM();
        }
        return instance;
    }

    public void addUnit(Unit unit){
        this.units.add(unit);
    }

    public void removeUnit(Unit unit){
        this.units.remove(unit);
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void newOccurence(){
        this.notifyAllUnits(generator.next());
    }

    public List<Occurence> getOngoingOcurrences() {
        return ongoingOcurrences;
    }

    public List<Occurence> getOccurances() {
        return occurances;
    }

    public void notifyUnit(Unit unit, Occurence occurence){
        unit.update(occurence);
    }

    public void notifyAllUnits(Occurence occurence){
        Double x = occurence.getX(), y = occurence.getY();
        TreeMap<Double, Unit> distances = new TreeMap<Double, Unit>();
        for(Unit unit : this.units){
            distances.put(unit.update(x, y), unit);
        }

        for(Map.Entry<Double,Unit> entry : distances.entrySet()){
            if (entry.getValue().update(occurence)) {
                System.out.println(occurence.getTrucksNeeded() + " Pojazdy wyjechaly z jednostki " + entry.getValue().getName());
                return;
            }
        }
        System.out.println("W zadnej jednostce nie ma pojazdow");
        this.ongoingOcurrences.remove(occurence);
    }
}
