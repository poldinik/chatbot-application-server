package it.unifi.ing.swam.dto;

import it.unifi.ing.swam.model.BaseEntity;

public abstract class AbstractAssembler<T extends BaseEntity, D extends BaseDto>{
    public abstract D createDataTransferObject(T t);
    public abstract void updateDomainObject(D dto);
    public abstract T createDomainObject(D dto);
}
