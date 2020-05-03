package it.unifi.ing.swam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TypeEntry {

    private String name;
    private List<String> values;
}
