package de.mobile.aol.data;

import java.util.*;

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

    public List<AutoEntry> findBy(String value) {
        List<AutoEntry> res = new ArrayList<AutoEntry>(5);

        StringTokenizer st = new StringTokenizer(value, " ", false);

        Map<String, Set<AutoEntry>> results = new HashMap<String, Set<AutoEntry>>();

        while (st.hasMoreElements()) {
            Set<AutoEntry> resultForToken = new HashSet<AutoEntry>();
            String token = st.nextToken();
            for (AutoEntry autoEntry : dataSet) {
                if (autoEntry.getMake().toLowerCase().contains(token.toLowerCase())) {
                    resultForToken.add(autoEntry);
                } else if (autoEntry.getModel().toLowerCase().contains(token.toLowerCase())) {
                    resultForToken.add(autoEntry);
                }
            }
            results.put(token, resultForToken);
        }

        Set<AutoEntry>intersection = null;

        for(Set<AutoEntry> set : results.values()){
            if (intersection == null){
                intersection = set;
            }else{
                intersection.retainAll(set);
            }
        }

        res.addAll(intersection);

        return res;
    }
}
