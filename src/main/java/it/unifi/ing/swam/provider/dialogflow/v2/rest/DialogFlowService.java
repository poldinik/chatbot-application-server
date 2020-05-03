package it.unifi.ing.swam.provider.dialogflow.v2.rest;


import it.unifi.ing.swam.provider.dialogflow.v2.schema.*;
import lombok.extern.log4j.Log4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.UUID;

@RequestScoped
@Log4j
public class DialogFlowService {

    @Inject
    @RestClient
    DialogFlowRestService dialogFlowRestService;

    @Inject
    GoogleAuthService googleAuthService;

    String projectId = "ilmionuovoagente-qfbbbf";

    public void changeName(String name) throws IOException {
        DialogFlowAgent dialogFlowAgent = new DialogFlowAgent();
        System.out.println("ProjectID: " + projectId);
        dialogFlowAgent.setParent("projects/" + projectId);
        dialogFlowAgent.setDisplayName(name);
        dialogFlowAgent.setDefaultLanguageCode("it");
        dialogFlowAgent.setTimeZone("Europe/Madrid");
        dialogFlowAgent.setMatchMode(MatchMode.MATCH_MODE_HYBRID);
        dialogFlowAgent.setApiVersion(ApiVersion.API_VERSION_V2);
        dialogFlowAgent.setTier(Tier.TIER_STANDARD);
        String authorization = "Bearer " + googleAuthService.getAccessToken();
        DialogFlowAgent dialogFlowAgent1 = dialogFlowRestService.postAgent(authorization, projectId, dialogFlowAgent);
    }

    public void createEntityType(EntityType entityType) throws IOException {
        String authorization = "Bearer " + googleAuthService.getAccessToken();
        dialogFlowRestService.entityTypes(authorization, projectId, entityType);
    }

    public void createIntent(DialogFlowIntent dialogFlowIntent) throws IOException {
        String authorization = "Bearer " + googleAuthService.getAccessToken();
        dialogFlowRestService.intents(authorization, projectId, dialogFlowIntent);
    }

    public DialogFlowAgent getAgent() throws IOException {
        String authorization = "Bearer " + googleAuthService.getAccessToken();
        return dialogFlowRestService.getAgent(authorization, projectId);
    }

    public String ask(String query) throws IOException {
        String authorization = "Bearer " + googleAuthService.getAccessToken();
        QueryInput queryInput = new QueryInput();
        TextInput textInput = new TextInput();
        textInput.setText(query);
        textInput.setLanguageCode("it");
        queryInput.setText(textInput);
        DetectIntentPayload detectIntentPayload = new DetectIntentPayload();
        detectIntentPayload.setQueryInput(queryInput);
        log.info(detectIntentPayload.toString());
        log.info("asking...");
        DetectIntentResponse detectIntentResponse = dialogFlowRestService.detectIntent(authorization, projectId, UUID.randomUUID().toString(), detectIntentPayload);
        log.info(detectIntentResponse.getQueryResult().toString());
        return detectIntentResponse.getQueryResult().getFulfillmentText();
    }
}
