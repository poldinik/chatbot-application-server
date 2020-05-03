package it.unifi.ing.swam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Agenti")
public class Agent extends BaseEntity {

    private String provider;
    private String name;
    private String defaultLanguageCode;
    private String timeZone;

    @JoinColumn(name = "intent_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    List<Intent> intents = new ArrayList<>();

    @JoinColumn(name = "type_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    List<Type> types = new ArrayList<>();


}
