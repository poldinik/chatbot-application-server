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
@Table(name = "Contesti")
public class Context extends BaseEntity {

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Life life;
}
