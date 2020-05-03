package it.unifi.ing.swam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParameterDto extends BaseDto {

    private String name;
    private Boolean required;
    private String prompt;
    private String typeName;
}

