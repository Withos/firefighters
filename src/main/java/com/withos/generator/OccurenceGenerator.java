package com.withos.generator;

import com.withos.entities.MZ;
import com.withos.entities.Occurence;
import com.withos.entities.PZ;
import com.withos.iterator.OccurancesIterator;
import com.withos.observer.SKKM;

import java.util.List;

public class OccurenceGenerator extends OccurancesIterator {

    public OccurenceGenerator(List<Occurence> occurences) {
        super(occurences);
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Occurence next() {
        double maxX = 50.154564013341734, minX = 49.95855025648944, maxY = 20.02470275868903, minY = 19.688292482742394;
        Occurence occurence;
        if(Math.random()<0.7)
            occurence = new MZ((Math.random() * (maxX - minX)) + minX, (Math.random() * (maxY - minY)) + minY);
        else
            occurence = new PZ((Math.random() * (maxX - minX)) + minX, (Math.random() * (maxY - minY)) + minY);
        SKKM.getInstance().getOccurances().add(occurence);
        SKKM.getInstance().getOngoingOcurrences().add(occurence);
        return occurence;
    }
}
