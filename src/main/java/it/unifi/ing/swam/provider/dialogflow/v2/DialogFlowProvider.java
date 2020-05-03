package it.unifi.ing.swam.provider.dialogflow.v2;


import it.unifi.ing.swam.dto.AgentDto;
import it.unifi.ing.swam.dto.IntentDto;
import it.unifi.ing.swam.dto.TypeDto;
import it.unifi.ing.swam.provider.Provider;
import it.unifi.ing.swam.provider.dialogflow.v2.mapper.EntityTypeMapper;
import it.unifi.ing.swam.provider.dialogflow.v2.mapper.IntentMapper;
import it.unifi.ing.swam.provider.dialogflow.v2.rest.DialogFlowService;
import it.unifi.ing.swam.provider.dialogflow.v2.schema.DialogFlowIntent;
import it.unifi.ing.swam.provider.dialogflow.v2.schema.EntityType;
import lombok.extern.log4j.Log4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@RequestScoped
@Log4j
public class DialogFlowProvider extends Provider {

    @ConfigProperty(name = "googleProjectId")
    String googleProjectId;

    @Inject
    DialogFlowService dialogFlowService;

    @Override
    public void deployAgent(AgentDto agentDto) throws IOException {
        log.info("Deploy on Google DialogFlow on project: " + googleProjectId);

        List<IntentDto> intentDtos = agentDto.getIntents();
        List<TypeDto> typeDtos = agentDto.getTypes();

        //crea le entitytype

        log.info("Creazione entity types Dialogflow");
        for (TypeDto typeDto : typeDtos) {
            EntityType entityType = EntityTypeMapper.create(typeDto, googleProjectId);
            dialogFlowService.createEntityType(entityType);
        }

        //crea intenti
        log.info("Creazione intent Dialogflow");
        for (IntentDto intent : intentDtos) {
            DialogFlowIntent dialogFlowIntent = IntentMapper.create(intent, typeDtos, googleProjectId);
            dialogFlowService.createIntent(dialogFlowIntent);
        }

    }

    @Override
    public String ask(String query) throws IOException {
        return dialogFlowService.ask(query);
    }
}




