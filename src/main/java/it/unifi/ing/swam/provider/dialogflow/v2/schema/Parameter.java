package it.unifi.ing.swam.provider.dialogflow.v2.schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Parameter {

    private String name;
    private String displayName;
    private String value;
    private String defaultValue;
    private String entityTypeDisplayName;
    private Boolean mandatory;
    private List<String> prompts;
    private Boolean isList;
}
