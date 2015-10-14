package de.mobile.aol.services;

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
public class SearchTest {

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
    public void testGet() throws Exception {
        String s = service.path("search/ping").getRequestBuilder().get(String.class);
        org.junit.Assert.assertEquals(s, "-31");

    }

    @Test
    public void testEmptySearch() throws Exception {
        String s = service.path("search").getRequestBuilder().get(String.class);
        org.junit.Assert.assertEquals("ACCTEST 1: Should show empty search spec page.",s,"search specification page");
    }



}