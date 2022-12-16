package com.iqbalnetwork.repositories.abstacts;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Optional;

@Transactional
public abstract class AbstractRepository<T, ID extends Serializable> implements GenericRepository<T, ID> {
    @PersistenceContext(unitName = "default")
    protected EntityManager entityManager;

    @Override
    public T save(T t) throws Exception {
        entityManager.persist(t);
        return t;
    }

    @Override
    public String delete(T t) throws Exception {
        entityManager.remove(t);
        return t + "was deleted";
    }
}
