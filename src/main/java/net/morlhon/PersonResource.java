package net.morlhon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.morlhon.jersey.Cache;

@Path("/person")
@Produces({ MediaType.APPLICATION_JSON })
public class PersonResource
{

    @Cache
    @GET
    @Path("/{id}")
    public Person getPerson(@QueryParam("id") int id)
    {
        return new Person(id);
    }
}
