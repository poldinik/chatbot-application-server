package it.unifi.ing.swam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Parametri")
public class Parameter extends BaseEntity {

    private String name;
    private String prompt;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Type type;

}
