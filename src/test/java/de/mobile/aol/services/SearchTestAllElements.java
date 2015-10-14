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
public class SearchTestAllElements {

    SelectorThread st;
    WebResource service;

    @Before
    public void setUp() throws Exception {
        Client client = Client.create(new DefaultClientConfig());
        service = client.resource(Main.BASE_URI);
        st = Main.start(new TestModuleAllElementsDP());
    }

    @After
    public void tearDown() throws Exception {
        st.stopEndpoint();
    }


    @Test
    public void testAllElements()throws Exception {
         String s = service.path("search/anything").getRequestBuilder().get(String.class);
        Gson g = new Gson();
        OneAutoEntry a = g.fromJson(s, OneAutoEntry.class);
        org.junit.Assert.assertNotNull("ACCTEST 2: page should contain for each found car the image", a.autoEntry.getImage());
        org.junit.Assert.assertNotNull("ACCTEST 2: page should contain for each found car the make",a.autoEntry.getMake());
        org.junit.Assert.assertNotNull("ACCTEST 2: page should contain for each found car the  model",a.autoEntry.getModel());
        org.junit.Assert.assertNotNull("ACCTEST 2: page should contain for each found car the  color ." ,a.autoEntry.getColor());
        org.junit.Assert.assertEquals("ACCTEST 2: page should contain for each found car the price." ,a.autoEntry.getPrice(), 32000);

    }



}