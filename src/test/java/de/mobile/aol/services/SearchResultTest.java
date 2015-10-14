package de.mobile.aol.services;

import com.google.gson.Gson;
import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import de.mobile.aol.Main;
import de.mobile.aol.data.AutoEntry;
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
    public void testAudi()throws Exception {
         String s = service.path("search/Audi").getRequestBuilder().get(String.class);
        Gson g = new Gson();
        AutoEntryArray a = g.fromJson(s, AutoEntryArray.class);
        org.junit.Assert.assertEquals("ACCTEST 3: page should results foe make", a.autoEntry.length, 2);
    }

    @Test
    public void testFord()throws Exception {
        String s = service.path("search/Ford").getRequestBuilder().get(String.class);
        Gson g = new Gson();
        OneAutoEntry a = g.fromJson(s, OneAutoEntry.class);
        org.junit.Assert.assertEquals("ACCTEST 3: page should have 1 ford", a.autoEntry, new AutoEntry("Persimmon red", "Ford", "Mustang", "convertable","", 32000));
    }

    @Test
    public void testTrabant()throws Exception {
        try {
            String s = service.path("search/Trabant").getRequestBuilder().get(String.class);
            org.junit.Assert.assertTrue("ACCTEST 3: page should have 0 trabant; this should never be hit", false);
        }catch (Exception e) {
            org.junit.Assert.assertTrue("ACCTEST 3: page should have 0 trabant; this should be hit", true);
        }
    }

    @Test
    public void testMustang()throws Exception {
        String s = service.path("search/Mustang").getRequestBuilder().get(String.class);
        Gson g = new Gson();
        OneAutoEntry a = g.fromJson(s, OneAutoEntry.class);
        org.junit.Assert.assertEquals("ACCTEST 4: page should have 1 Mustang", a.autoEntry, new AutoEntry("Persimmon red", "Ford", "Mustang", "convertable","", 32000));
    }

    @Test
    public void testAudiA4()throws Exception {
        String s = service.path("search/Audi a4").getRequestBuilder().get(String.class);
        Gson g = new Gson();
        AutoEntryArray a = g.fromJson(s, AutoEntryArray.class);
        org.junit.Assert.assertEquals("ACCTEST 5: page should result in two a4 ", a.autoEntry.length, 2);
    }

    @Test
    public void testAudiMustang()throws Exception {
        try {
            String s = service.path("search/Audi Mustang").getRequestBuilder().get(String.class);
            org.junit.Assert.assertTrue("ACCTEST 3: page should have 0 trabant; this should never be hit", false);
        }catch (Exception e) {
            org.junit.Assert.assertTrue("ACCTEST 3: page should have 0 trabant; this should be hit", true);
        }
    }

}