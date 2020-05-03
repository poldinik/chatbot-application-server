package it.unifi.ing.swam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "FrasiDiEsempio")
public class Phrase extends BaseEntity {

    @Column(columnDefinition="TEXT")
    private String value;
}
