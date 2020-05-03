package it.unifi.ing.swam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AgentDto extends BaseDto {

    private String provider;
    private String name;
    private String lang;
    private List<IntentDto> intents;
    private List<TypeDto> types;
    private List<ContextDto> contexts;

}

