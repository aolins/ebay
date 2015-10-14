package de.mobile.aol.services;

import com.google.inject.AbstractModule;
import de.mobile.aol.data.DataProvider;

/**
 * Created by aol on 2015.10.14..
 */
public class TestModuleAllElementsDP extends AbstractModule {
    @Override
    protected void configure() {
        bind(DataProvider.class).to(AlwaysOneEntryStaticProvider.class);
    }
}