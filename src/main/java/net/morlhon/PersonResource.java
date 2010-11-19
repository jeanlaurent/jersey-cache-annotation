package net.morlhon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/person")
@Produces({ MediaType.APPLICATION_JSON })
public class PersonResource
{

    @GET
    @Path("/{id}")
    public Person getPerson(@QueryParam("id") int id)
    {
        return new Person(id);
    }
}
