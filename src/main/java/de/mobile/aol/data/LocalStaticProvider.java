package de.mobile.aol.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aol on 2015.10.14..
 */
public class LocalStaticProvider implements DataProvider {

    private Set<AutoEntry> dataSet = new HashSet<AutoEntry>(5);

    public LocalStaticProvider() {
        dataSet.add(new AutoEntry("Persimmon red", "Ford", "Mustang", "convertable","", 32000));
        dataSet.add(new AutoEntry("Midnight blue", "Buick", "Lacrosse", "limousine", "Xenon headlight", 29000));
        dataSet.add(new AutoEntry("Ocean blue", "BMW", "X5", "limousine", "LED headlight", 79000));
        dataSet.add(new AutoEntry("British racing green", "Audi", "A4", "convertable","", 6700));
        dataSet.add(new AutoEntry("Scarlet red", "Audi", "A4", "limousine","", 4500));
    }

    public List<AutoEntry> findBy(String field, String value) {
        List<AutoEntry> res = new ArrayList<AutoEntry>(5);
        res.addAll(dataSet);
        return res;
    }
}
