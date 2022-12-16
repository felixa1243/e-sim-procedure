package com.iqbalnetwork.repositories.abstacts;

import java.io.Serializable;
import java.util.Optional;

public interface GenericRepository<T, ID extends Serializable> {
    T save(T t) throws Exception;

    Optional<T> findById(ID id) throws Exception;

    String delete(T t) throws Exception;
}
