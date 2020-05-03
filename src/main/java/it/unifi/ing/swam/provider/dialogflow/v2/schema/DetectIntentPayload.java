package it.unifi.ing.swam.provider.dialogflow.v2.schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DetectIntentPayload {

    QueryInput queryInput;
}
