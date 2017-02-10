package com.eliti.hello.resources;

import com.eliti.hello.model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.ok;

@Path("hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource {

  @GET
  @Path("/{name}")
  public Response hello(@PathParam("name") String name) {
    return ok(new Message("Hello " + name + "!")).build();
  }

}
