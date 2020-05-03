package it.unifi.ing.swam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class IntentDto extends BaseDto {

    private String name;
    private List<String> phrases = new ArrayList<>();
    private List<ParameterDto> parameters = new ArrayList<>();
    private List<String> answers = new ArrayList<>();
    private List<String> contextContraints = new ArrayList<>();
    private List<String> contextsToActive = new ArrayList<>();
}

