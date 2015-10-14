package de.mobile.aol.services;

import com.google.gson.Gson;
import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import de.mobile.aol.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by aol on 2015.10.14..
 */
public class SearchResultTest {

    SelectorThread st;
    WebResource service;

    @Before
    public void setUp() throws Exception {
        Client client = Client.create(new DefaultClientConfig());
        service = client.resource(Main.BASE_URI);
        st = Main.start(new TestModule());
    }

    @After
    public void tearDown() throws Exception {
        st.stopEndpoint();
    }


    @Test
    public void testAllElements()throws Exception {
         String s = service.path("search/Audi").getRequestBuilder().get(String.class);
        Gson g = new Gson();
        AutoEntryArray a = g.fromJson(s, AutoEntryArray.class);
        org.junit.Assert.assertEquals("ACCTEST 3: page should results foe make", a.autoEntry.length, 2);
    }



}