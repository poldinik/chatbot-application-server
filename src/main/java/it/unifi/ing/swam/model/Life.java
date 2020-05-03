package it.unifi.ing.swam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TempoDiVita")
public class Life extends BaseEntity {

    private int time;
}
