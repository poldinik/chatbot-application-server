package it.unifi.ing.swam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TypeDto extends BaseDto {

    private String name;
    private List<String> possibileValues;
    private List<TypeEntry> possibleEntries;
}
