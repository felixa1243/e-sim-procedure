package com.iqbalnetwork.repositories;

import com.iqbalnetwork.entities.Credential;
import com.iqbalnetwork.repositories.abstacts.AbstractRepository;
import com.iqbalnetwork.repositories.interfaces.CredentialRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class CredentialRepositoryImpl extends AbstractRepository<Credential, String> implements CredentialRepository {
    @Override
    public Optional<Credential> findById(String s) throws Exception {
        TypedQuery<Credential> query = entityManager.createQuery("SELECT * FROM credential where id=:id", Credential.class);
        query.setParameter("id", s);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public Optional<Credential> findByUsername(String username) {
        TypedQuery<Credential> query = entityManager.createQuery("SELECT c FROM Credential c where c.username=:username", Credential.class);
        query.setParameter("username", username);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public Optional<Credential> getUserDetails(Authentication authentication) {
        TypedQuery<Credential> query = entityManager.createQuery("SELECT c FROM Credential c JOIN UserEntity where j", Credential.class);
        query.setParameter("username", authentication.getName());
        return Optional.of(query.getSingleResult());
    }
}
