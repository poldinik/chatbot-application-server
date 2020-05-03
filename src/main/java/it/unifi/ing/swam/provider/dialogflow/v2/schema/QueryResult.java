package it.unifi.ing.swam.provider.dialogflow.v2.schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QueryResult {

    String fulfillmentText;
    List<Message> fulfillmentMessages;
    DialogFlowIntent intent;
}
