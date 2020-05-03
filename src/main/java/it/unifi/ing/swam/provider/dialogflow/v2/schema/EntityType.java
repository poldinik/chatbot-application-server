package it.unifi.ing.swam.provider.dialogflow.v2.schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EntityType {

    private String name;
    private String displayName;
    private Kind kind;
    private AutoExpansionMode autoExpansionMode;
    private List<Entity> entities;
    private Boolean enableFuzzyExtraction;

    @Override
    public String toString() {
        return "EntityType{" + "name='" + name + '\'' + ", displayName='" + displayName + '\'' + ", kind=" + kind + ", autoExpansionMode=" + autoExpansionMode + ", entities=" + entities + ", enableFuzzyExtraction=" + enableFuzzyExtraction + '}';
    }
}
