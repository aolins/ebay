package de.mobile.aol.services;

import de.mobile.aol.data.AutoEntry;
import de.mobile.aol.data.DataProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aol on 2015.10.14..
 */
public class AlwaysOneEntryStaticProvider implements DataProvider {

    private Set<AutoEntry> dataSet = new HashSet<AutoEntry>(1);

    public AlwaysOneEntryStaticProvider() {
        dataSet.add(new AutoEntry("Persimmon red", "Ford", "Mustang", "convertable","LED all", 32000));

    }

    public List<AutoEntry> findBy(String value) {
        List<AutoEntry> res = new ArrayList<AutoEntry>(1);
        res.addAll(dataSet);
        return res;
    }
}
