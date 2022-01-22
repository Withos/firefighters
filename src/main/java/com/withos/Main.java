package com.withos;

import com.withos.entities.Unit;
import com.withos.observer.SKKM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sec;
        Scanner s = new Scanner(System.in);
        System.out.println("Ile sekund chcesz zasymulowac?");
        sec = s.nextInt();
        SKKM.getInstance().addUnit(new Unit(50.05995226043588, 19.943098143545765, "JGR-1"));
        SKKM.getInstance().addUnit(new Unit(50.03769479938924, 20.005762540886952, "JGR-2"));
        SKKM.getInstance().addUnit(new Unit(50.07572185315024, 19.88731890902201, "JGR-3"));
        SKKM.getInstance().addUnit(new Unit(50.03769731418135, 20.005763007388005, "JGR-4"));
        SKKM.getInstance().addUnit(new Unit(50.09223930814437, 19.922137624053534, "JGR-5"));
        SKKM.getInstance().addUnit(new Unit(50.01612802410015, 20.0156193812567, "JGR-6"));
        SKKM.getInstance().addUnit(new Unit(50.09407717429361, 19.977442894330355, "JGR-7"));
        SKKM.getInstance().addUnit(new Unit(50.07710009370106, 20.032667713835345, "JRG Szkoly Aspirantow PSP"));
        SKKM.getInstance().addUnit(new Unit(49.96838789301483, 19.799507230999783, "JRG Skawina"));
        SKKM.getInstance().addUnit(new Unit(50.07324970752219, 19.785873240870146, "LSP Lotniska w Balicach"));
        for (Unit unit : SKKM.getInstance().getUnits())
            unit.generateTrucks(5);
        while(sec>0){
            if(Math.random()<0.4)
                SKKM.getInstance().newOccurence();
            for (int i = 0; i < SKKM.getInstance().getOngoingOcurrences().size(); i++)
                SKKM.getInstance().getOngoingOcurrences().get(i).getStrategy().execute();
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            sec--;
        }
        System.out.println("Koniec symulacji");
    }
}
