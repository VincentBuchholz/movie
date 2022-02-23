package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.Populator;
import utils.EMF_Creator;
import facades.MovieFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movie")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final MovieFacade FACADE =  MovieFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(GSON.toJson(FACADE.getAll())).build();
    }


    @GET
    @Path("populate")
    @Produces({MediaType.APPLICATION_JSON})
    public Response populate() {
        Populator.populate();
        return Response.ok().entity(GSON.toJson(FACADE.getAll())).build();
    }

    @GET
    @Path("/id/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id")long id) {
        return Response.ok().entity(GSON.toJson(FACADE.getById(id))).build();
    }


}
