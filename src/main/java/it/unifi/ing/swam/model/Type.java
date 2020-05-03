package it.unifi.ing.swam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Tipi")
public class Type extends BaseEntity {

    private String name;

    @ElementCollection
    @Column(columnDefinition="TEXT")
    private List<String> possibileValues = new ArrayList<>();
}
