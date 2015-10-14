package de.mobile.aol.services;

import com.google.inject.Inject;
import de.mobile.aol.data.AutoEntry;
import de.mobile.aol.data.DataProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by aol on 2015.10.14..
 */
@Path("search")
public class Search {

    @Inject
    public Search(DataProvider dp){
        provider = dp;
    }
    private final DataProvider provider;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response emptyGet(){
        //totally mocked endpoint
        return Response.ok("search specification page").build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ping")
    public Response ping(){
        return Response.ok("-31").build();
    }


    @Path("{query}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("query") String query) throws Exception{
        List<AutoEntry> c = provider.findBy(null, query);
        if (c==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else{
            GenericEntity<List<AutoEntry>> entity = new GenericEntity<List<AutoEntry>>(c) {};
            Response response = Response.ok(entity).build();
            return response;
        }
    }



}
