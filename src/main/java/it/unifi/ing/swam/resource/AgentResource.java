package it.unifi.ing.swam.resource;

import it.unifi.ing.swam.controller.AgentController;
import it.unifi.ing.swam.dto.AgentDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/agents")
public class AgentResource {

    @Inject
    AgentController controller;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(AgentDto agentDto) throws IOException {
        controller.create(agentDto);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Integer id){
        return Response.ok(controller.getAgentById(id), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("{id}/ask")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ask(@PathParam("id") int agentId, @QueryParam("query") String query) throws IOException {
        return Response.ok(controller.ask(query), MediaType.APPLICATION_JSON).build();
    }
}
