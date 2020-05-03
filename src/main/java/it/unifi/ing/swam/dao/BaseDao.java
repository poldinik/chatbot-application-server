package it.unifi.ing.swam.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless
public class BaseDao {

    @PersistenceContext(unitName = "persistenceUnitName", type = PersistenceContextType.EXTENDED)
    protected EntityManager entityManager;
}
