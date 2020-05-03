package it.unifi.ing.swam.provider.dialogflow.v2.schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Entity {
    private String value;
    private List<String> synonyms = new ArrayList<>();

    public void addSynonym(String synonym){
        synonyms.add(synonym);
    }

    @Override
    public String toString() {
        return "Entity{" + "value='" + value + '\'' + ", synonyms=" + synonyms + '}';
    }
}
