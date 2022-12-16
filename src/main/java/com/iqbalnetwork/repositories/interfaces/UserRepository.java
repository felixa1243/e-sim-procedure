package com.iqbalnetwork.repositories.interfaces;

import com.iqbalnetwork.entities.UserEntity;
import com.iqbalnetwork.repositories.abstacts.GenericRepository;

import java.util.Optional;

public interface UserRepository extends GenericRepository<UserEntity, String> {
    Optional<UserEntity> findByUserName(String userName);
}
