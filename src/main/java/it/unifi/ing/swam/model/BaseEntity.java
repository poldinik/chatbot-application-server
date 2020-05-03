package it.unifi.ing.swam.model;


import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @SequenceGenerator(name = "base")
    @GeneratedValue
    protected Integer id;
    protected String uuid;
    @JsonbDateFormat("dd-MM-yyyy")
    protected Date created;
    @JsonbDateFormat("dd-MM-yyyy")
    protected Date updated;

    public BaseEntity(){
        created = new Date();
        updated = new Date();
        uuid = UUID.randomUUID().toString();
    }
}
