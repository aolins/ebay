package de.mobile.aol.services;

import com.google.inject.AbstractModule;
import de.mobile.aol.data.DataProvider;
import de.mobile.aol.data.LocalStaticProvider;

/**
 * Created by aol on 2015.10.14..
 */
public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DataProvider.class).to(LocalStaticProvider.class);
    }
}