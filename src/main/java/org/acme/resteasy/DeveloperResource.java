package org.acme.resteasy;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/jax-rs-developer")
public class DeveloperResource {
    
    @Inject
    DeveloperRepository developerRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> developers(@QueryParam("chilean") boolean chilean) {
        if (chilean) {
            return developerRepository.findByName("jpv");
        }
        return developerRepository.findAll().list();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newDeveloper(@Valid Developer developer) {
        developer.id = null;
        developer.persist();
        return Response.status(Status.CREATED)
            .entity(developer)
            .build();
        }
}
