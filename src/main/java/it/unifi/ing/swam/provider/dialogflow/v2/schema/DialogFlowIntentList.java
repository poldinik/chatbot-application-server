package it.unifi.ing.swam.provider.dialogflow.v2.schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DialogFlowIntentList {

    private List<DialogFlowIntent> intents;
    private String nextPageToken;
}
