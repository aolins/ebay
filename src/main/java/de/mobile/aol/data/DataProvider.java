package de.mobile.aol.data;

import java.util.List;

/**
 * Created by aol on 2015.10.14..
 */
public interface DataProvider {
    public List<AutoEntry> findBy(String field, String value);
    public List<AutoEntry> findBy(String field, long value);

}
