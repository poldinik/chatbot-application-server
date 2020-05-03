package it.unifi.ing.swam.provider.dialogflow.v2.schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TraininingPhrase {
    private String name;
    private Type type;
    private List<Part> parts;
    private Integer timesAddedCount;
}
