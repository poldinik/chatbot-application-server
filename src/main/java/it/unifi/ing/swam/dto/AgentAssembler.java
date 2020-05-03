package it.unifi.ing.swam.dto;

import it.unifi.ing.swam.model.*;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestScoped
public class AgentAssembler extends AbstractAssembler<Agent, AgentDto> {


    @Override
    public AgentDto createDataTransferObject(Agent agent) {
        return null;
    }

    @Override
    public void updateDomainObject(AgentDto dto) {

    }

    @Override
    public Agent createDomainObject(AgentDto dto) {

        List<IntentDto> intentDtos = dto.getIntents();
        List<ContextDto> contextDtos = dto.getContexts();
        List<TypeDto> typeDtos = dto.getTypes();
        String agentName = dto.getName();
        String agentLanguage = dto.getLang();
        String agentProvider = dto.getProvider();

        Agent agent = new Agent();

        agent.setName(agentName);
        agent.setDefaultLanguageCode("it");
        agent.setTimeZone("Europe/Madrid");
        agent.setProvider(agentProvider);

        //costruisce i tipi

        HashMap<String, Type> typeHashMap = new HashMap<>();
        List<Type> types = new ArrayList<>();

        for (TypeDto typeDto : typeDtos) {
            Type type = new Type();
            type.setName(typeDto.getName());
            //type.setPossibileValues(typeDto.getPossibileValues());
            typeHashMap.put(type.getName(), type);
            types.add(type);
            List<TypeEntry> typeEntries = typeDto.getPossibleEntries();

            //mappa le type entry in un unica lista
            List<String> possibleValues = new ArrayList<>();
            for (TypeEntry typeEntry:typeEntries) {
                possibleValues.addAll(typeEntry.getValues());
            }

            type.setPossibileValues(possibleValues);
        }

        //costruisce i contesti

        HashMap<String, Context> contextHashMap = new HashMap<>();

        for(ContextDto contextDto: contextDtos){
            Context context = new Context();
            context.setName(contextDto.getName());

            Life life = new Life();
            life.setTime(contextDto.getLife());
            context.setLife(life);

            contextHashMap.put(contextDto.getName(), context);
        }


        List<Intent> intents = new ArrayList<>();

        for (IntentDto intentDto : intentDtos) {
            Intent intent = new Intent();
            intent.setName(intentDto.getName());

            List<Phrase> phrases = new ArrayList<>();
            for (String f : intentDto.getPhrases()) {
                Phrase phrase = new Phrase();
                phrase.setValue(f);
                phrases.add(phrase);
            }

            intent.setPhrases(phrases);

            List<Parameter> parameters = new ArrayList<>();
            List<Parameter> requiredParameters = new ArrayList<>();

            for (ParameterDto parameterDto : intentDto.getParameters()) {

                Parameter parameter = new Parameter();
                parameter.setName(parameterDto.getTypeName());
                parameter.setType(typeHashMap.get(parameterDto.getTypeName()));
                parameter.setPrompt(parameterDto.getPrompt());
                if (parameterDto.getRequired()){
                    requiredParameters.add(parameter);
                }else {
                    parameters.add(parameter);
                }
            }

            intent.setRequiredParameters(requiredParameters);
            intent.setParameters(parameters);

            List<ContextRel> contextRelList = new ArrayList<>();

            for(String inputContextName: intentDto.getContextContraints()){

                createContextRel(contextHashMap, contextRelList, inputContextName, "constraints");
            }

            for(String outputContextName: intentDto.getContextsToActive()){

                createContextRel(contextHashMap, contextRelList, outputContextName, "actives");
            }

            intent.setContextRelList(contextRelList);

            List<TextResponse> textResponses = new ArrayList<>();
            for (String response : intentDto.getAnswers()) {
                TextResponse textResponse = new TextResponse();
                textResponse.setText(response);
                textResponses.add(textResponse);
            }

            intent.setTextResponses(textResponses);
        }

        agent.setIntents(intents);

        return agent;
    }

    private void createContextRel(HashMap<String, Context> contextHashMap, List<ContextRel> contextRelList, String inputContextName, String constraints) {
        ContextRel contextRel = new ContextRel();
        Context context = contextHashMap.get(inputContextName);
        ContextRelType contextRelType = new ContextRelType();
        contextRelType.setType(constraints);
        contextRel.setContext(context);
        contextRel.setContextRelType(contextRelType);
        contextRelList.add(contextRel);
    }


}

