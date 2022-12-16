package com.iqbalnetwork.repositories.interfaces;

import com.iqbalnetwork.entities.Credential;
import com.iqbalnetwork.repositories.abstacts.GenericRepository;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface CredentialRepository extends GenericRepository<Credential, String> {
    Optional<Credential> findByUsername(String userId);
    Optional<Credential> getUserDetails(Authentication authentication);
}
