package de.mobile.aol;

import com.google.inject.AbstractModule;
import de.mobile.aol.data.DataProvider;
import de.mobile.aol.data.LocalStaticProvider;

/**
 * Created by aol on 2015.09.20..
 */
public class RunModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(DataProvider.class).to(LocalStaticProvider.class);
        }
}
