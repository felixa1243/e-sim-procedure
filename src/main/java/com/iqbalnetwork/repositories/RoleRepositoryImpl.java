package com.iqbalnetwork.repositories;

import com.iqbalnetwork.entities.Roles;
import com.iqbalnetwork.repositories.abstacts.AbstractRepository;
import com.iqbalnetwork.repositories.interfaces.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class RoleRepositoryImpl extends AbstractRepository<Roles, String> implements RoleRepository {
    @Override
    public Optional<Roles> findByName(String name) {
        TypedQuery<Roles> query = entityManager.createQuery("SELECT r FROM  Roles r WHERE roleName=:name", Roles.class);
        query.setParameter("name", name);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public Optional<Roles> findById(String s) throws Exception {
        return Optional.empty();
    }
}
