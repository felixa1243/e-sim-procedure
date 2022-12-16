package com.iqbalnetwork.repositories.interfaces;

import com.iqbalnetwork.entities.Roles;
import com.iqbalnetwork.repositories.abstacts.AbstractRepository;
import com.iqbalnetwork.repositories.abstacts.GenericRepository;

import java.util.Optional;

public interface RoleRepository extends GenericRepository<Roles,String> {
    Optional<Roles> findByName(String name);
}
