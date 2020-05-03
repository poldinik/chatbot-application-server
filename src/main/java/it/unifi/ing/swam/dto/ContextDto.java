package it.unifi.ing.swam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ContextDto extends BaseDto {

    private String name;
    private int life;
}

