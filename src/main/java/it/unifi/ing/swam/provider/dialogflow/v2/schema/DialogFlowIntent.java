package it.unifi.ing.swam.provider.dialogflow.v2.schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DialogFlowIntent {

    private String name;
    private String displayName;
    private WebhookState webhookState;
    private Integer priority;
    private Boolean isFallback;
    private Boolean mlDisabled;
    private List<String> inputContextNames;
    private List<String> events;
    private List<TraininingPhrase> trainingPhrases;
    private String action;
    private List<Context> outputContexts;
    private Boolean resetContexts;
    private List<Parameter> parameters;
    private List<Message> messages;
//    private Platform[] defaultResponsePlatforms;
//    private String rootFollowupIntentName;
//    private String parentFollowupIntentName;
//    private FollowupIntentInfo[] followupIntentInfo;

}
