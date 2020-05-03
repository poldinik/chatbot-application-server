package it.unifi.ing.swam.provider.dialogflow.v2.rest;

import it.unifi.ing.swam.provider.dialogflow.v2.schema.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@Path("/v2")
@RegisterRestClient
public interface DialogFlowRestService {

    @POST
    @Path("/projects/{projectId}/agent")
    @Consumes("application/json")
    @Produces("application/json")
    DialogFlowAgent postAgent(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, DialogFlowAgent dialogFlowAgent);

    @GET
    @Path("/projects/{projectId}/agent")
    @Produces("application/json")
    DialogFlowAgent getAgent(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId);

    @POST
    @Path("/projects/{projectId}/agent/entityTypes")
    @Consumes("application/json")
    @Produces("application/json")
    EntityType entityTypes(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, EntityType entityType);

    @GET
    @Path("/projects/{projectId}/agent/entityTypes")
    @Consumes("application/json")
    @Produces("application/json")
    DialogFlowEntityTypeList getEntityTypes(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId);

    @POST
    @Path("/projects/{projectId}/agent/entityTypes/{entityType}/entities:batchCreate")
    @Consumes("application/json")
    @Produces("application/json")
    Operation entitiesBatchCreate(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("entityType") String entityType, @QueryParam("key") String key, BatchEntities batchEntities);

    @POST
    @Path("/projects/{projectId}/agent/intents")
    @Consumes("application/json")
    @Produces("application/json")
    EntityType intents(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, DialogFlowIntent dialogFlowIntent);

    @GET
    @Path("/projects/{projectId}/agent/intents")
    @Consumes("application/json")
    @Produces("application/json")
    DialogFlowIntentList getIntents(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId);

    @POST
    @Path("/projects/{projectId}/agent/sessions/{sessionId}:detectIntent")
    @Consumes("application/json")
    @Produces("application/json")
    DetectIntentResponse detectIntent(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("sessionId") String sessionId, DetectIntentPayload detectIntentPayload);
}
