package it.unifi.ing.swam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Intenti")
public class Intent extends BaseEntity {

    private String name;

    @JoinColumn(name = "contextRel_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ContextRel> contextRelList = new ArrayList<>();

    @JoinColumn(name = "requiredParameter_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Parameter> requiredParameters = new ArrayList<>();

    @JoinColumn(name = "parameter_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Parameter> parameters = new ArrayList<>();

    @JoinColumn(name = "phrase_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Phrase> phrases = new ArrayList<>();

    @JoinColumn(name = "textResponse_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<TextResponse> textResponses;
}
