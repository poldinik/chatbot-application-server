package it.unifi.ing.swam.provider.dialogflow.v2.mapper;

import it.unifi.ing.swam.dto.IntentDto;
import it.unifi.ing.swam.dto.ParameterDto;
import it.unifi.ing.swam.dto.TypeDto;
import it.unifi.ing.swam.dto.TypeEntry;
import it.unifi.ing.swam.provider.dialogflow.v2.schema.*;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Log4j
public class IntentMapper {

    public static DialogFlowIntent create(IntentDto intentDto, List<TypeDto> typeDtos, String projectId){

        log.info("Creo un DialogFlow Intent");
        DialogFlowIntent dialogFlowIntent = new DialogFlowIntent();

        //name
        dialogFlowIntent.setDisplayName(intentDto.getName());

        //inputContextNames

        List<String> inputContextNames = new ArrayList<>();

        log.info("Elaborazione context input per DialogFlow Intent");
        for (String icn : intentDto.getContextContraints()) {

            //controlla che il nome del context non abbia spazi, deve essere unica stringa con - eventualmente
            String[] splitted = icn.split(" ");
            String nicn = "";
            if(splitted.length > 0){
                for (String s : splitted) {
                    nicn += s;
                }
            }else {
                nicn = icn;
            }


            inputContextNames.add("projects/" + projectId + "/agent/sessions/-/contexts/" + nicn);
        }

        dialogFlowIntent.setInputContextNames(inputContextNames);


        log.info("Elaborazione contextoutput per DialogFlow Intent");
        //outputContext
        List<Context> outputContexts = new ArrayList<>();

        for (String oc : intentDto.getContextsToActive()) {
            Context context = new Context();
            context.setLifespanCount(5);
            String contextName = "projects/" +  projectId + "/agent/sessions/-/contexts/" + oc;
            context.setName(contextName);
            outputContexts.add(context);
        }

        dialogFlowIntent.setOutputContexts(outputContexts);

        //messages

        log.info("Elaborazione messaggi per DialogFlow Intent");
        List<Message> messages = new ArrayList<>();
        Message message = new Message();
        Text text = new Text();
        message.setText(text);
        messages.add(message);

        for (String ans : intentDto.getAnswers()) {
            text.getText().add(ans);
        }

        dialogFlowIntent.setMessages(messages);

        //parameters

        log.info("Creazione frasi di training per DialogFlow Intent");
        //trainining prhases
        List<TraininingPhrase> traininingPhrases = new ArrayList<>();

        for (String content : intentDto.getPhrases()) {

            TraininingPhrase traininingPhrase = new TraininingPhrase();
            traininingPhrase.setType(Type.EXAMPLE);
            traininingPhrase.setName(UUID.randomUUID().toString());
            traininingPhrase.setTimesAddedCount(1);

            String[] splitted = content.split(" ");

            List<Part> parts = new ArrayList<>();
            for (String token : splitted) {
                log.info("token: " + token);
                Part part = new Part();
                part.setText(token + " ");
                String associatedType = findAssociatedType(token, typeDtos);

                if(associatedType != null){
                    log.info("associated type: " + associatedType);
                    part.setEntityType("@" + associatedType);
                    part.setAlias(associatedType);
                }
                parts.add(part);
            }

            traininingPhrase.setParts(parts);
            traininingPhrases.add(traininingPhrase);
        }

        dialogFlowIntent.setTrainingPhrases(traininingPhrases);

        log.info("Creazione parametri per DialogFlow Intent");
        List<Parameter> parameters = new ArrayList<>();

        for (ParameterDto parameterDTO: intentDto.getParameters()) {
            Parameter parameter = new Parameter();
            parameter.setDisplayName(parameterDTO.getName());
            parameter.setEntityTypeDisplayName("@" + parameterDTO.getTypeName());
            parameter.setMandatory(true);
            List<String> prompts = new ArrayList<>();
            prompts.add(parameterDTO.getPrompt());
            parameter.setPrompts(prompts);
            parameter.setValue("$" + parameterDTO.getTypeName());
            parameters.add(parameter);
        }

        dialogFlowIntent.setParameters(parameters);


        return dialogFlowIntent;
    }

    private static String findAssociatedType(String token, List<TypeDto> typeDtos){
        String at = null;

        for (TypeDto typeDto : typeDtos) {
            for (TypeEntry te : typeDto.getPossibleEntries()) {
                for (String v : te.getValues()) {
                    if (token.equals(v)) {
                        at = typeDto.getName();
                        break;
                    }
                }
            }
        }

        return at;
    }
}
