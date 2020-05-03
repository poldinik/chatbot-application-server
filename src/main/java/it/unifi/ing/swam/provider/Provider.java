package it.unifi.ing.swam.provider;

import it.unifi.ing.swam.dto.AgentDto;
import it.unifi.ing.swam.provider.dialogflow.v2.DialogFlowProvider;

import java.io.IOException;

public abstract class Provider {

    public static Provider getProvider(ProviderType type){

        Provider provider = new DialogFlowProvider();

        switch (type){

            case DIALOGFLOW:
                provider =  new DialogFlowProvider();
                break;
        }

        return provider;
    }

    public abstract void deployAgent(AgentDto agentDto) throws IOException;

    public abstract String ask(String query) throws IOException;
}
