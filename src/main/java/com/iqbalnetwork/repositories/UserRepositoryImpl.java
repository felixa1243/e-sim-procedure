package com.iqbalnetwork.repositories;

import com.iqbalnetwork.entities.UserEntity;
import com.iqbalnetwork.repositories.abstacts.AbstractRepository;
import com.iqbalnetwork.repositories.interfaces.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserRepositoryImpl extends AbstractRepository<UserEntity, String> implements UserRepository {
    @Override
    public Optional<UserEntity> findById(String s) throws Exception {
        TypedQuery<UserEntity> result = entityManager.createQuery("SELECT s FROM UserEntity s WHERE id= :id", UserEntity.class);
        result.setParameter("id", s);
        return Optional.of(result.getSingleResult());
    }

    @Override
    public Optional<UserEntity> findByUserName(String userName) {
        TypedQuery<UserEntity> result = entityManager.createQuery("SELECT s FROM UserEntity s WHERE userName= :userName", UserEntity.class);
        return Optional.of(result.getSingleResult());
    }
}
