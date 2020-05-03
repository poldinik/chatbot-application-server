package it.unifi.ing.swam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "RelazioniContesti")
public class ContextRel extends BaseEntity {

    @JoinColumn(name = "intent_id")
    @ManyToOne
    private Intent intent;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Context context;

    @OneToOne(cascade = CascadeType.PERSIST)
    private ContextRelType contextRelType;

}
