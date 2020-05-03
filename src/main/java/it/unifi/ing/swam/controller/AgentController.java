package it.unifi.ing.swam.controller;

import it.unifi.ing.swam.dao.AgentDao;
import it.unifi.ing.swam.dto.AgentAssembler;
import it.unifi.ing.swam.dto.AgentDto;
import it.unifi.ing.swam.model.Agent;
import it.unifi.ing.swam.provider.dialogflow.v2.DialogFlowProvider;
import lombok.extern.log4j.Log4j;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.IOException;

@RequestScoped
@Log4j
public class AgentController {

    @Inject
    AgentAssembler agentAssembler;

    @Inject
    AgentDao agentDao;

    @Inject
    DialogFlowProvider dialogflowProvider;

    public void create(AgentDto agentDto) throws IOException {
        Agent agent = agentAssembler.createDomainObject(agentDto);
        log.info("Salvataggio agente su domain model...");
        agentDao.create(agent);
        log.info("Salvataggio agente su domain model completata!");
        log.info("Deploy Dialogflow in corso...");
        dialogflowProvider.deployAgent(agentDto);
        log.info("Deploy Dialogflow completato!");
    }

    public String ask(String query) throws IOException {
        return dialogflowProvider.ask(query);
    }

    public AgentDto getAgentById(Integer id) {
        return agentAssembler.createDataTransferObject(agentDao.getAgentById(id));
    }
}
