package it.unifi.ing.swam.dao;

import it.unifi.ing.swam.model.BaseEntity;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;
import java.lang.reflect.ParameterizedType;
import java.util.Date;

public abstract class Crud<T extends BaseEntity> extends BaseDao {
    public T create(T entity) throws EntityExistsException, IllegalStateException, IllegalArgumentException, TransactionRequiredException {
        entityManager.persist(entity);
        return entity;
    }

    public T read(Integer primaryKey) throws IllegalStateException, IllegalArgumentException{
        return entityManager.find(getGenericTypeClass(), primaryKey);
    }

    public void update(T entity) throws IllegalStateException, IllegalArgumentException, TransactionRequiredException {
        entity.setUpdated(new Date());
        entityManager.merge(entity);
    }

    public void delete(T entity) throws IllegalStateException, IllegalArgumentException, TransactionRequiredException {
        entityManager.remove(entity);
    }

    @SuppressWarnings("unchecked")
    private Class<T> getGenericTypeClass() {
        try {
            String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
            Class<?> clazz = Class.forName(className);
            return (Class<T>) clazz;
        } catch (Exception e) {
            throw new IllegalStateException("Class is not parametrized with generic type!!! Please use extends <> ");
        }
    }


}
