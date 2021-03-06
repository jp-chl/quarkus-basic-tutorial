package org.acme.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/resteasy/hello")
public class ExampleResource {

    @ConfigProperty(name = "greeting")
    Optional<String> greeting;
 
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greeting.orElse("hello");
    }

    @Path("/async")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> helloAsync() {
        return CompletableFuture.supplyAsync(() -> "Hello, I'm async");
    }
}