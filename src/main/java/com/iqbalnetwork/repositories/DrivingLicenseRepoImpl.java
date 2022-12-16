package com.iqbalnetwork.repositories;

import com.iqbalnetwork.entities.DrivingLicense;
import com.iqbalnetwork.repositories.abstacts.AbstractRepository;
import com.iqbalnetwork.repositories.interfaces.DrivingLicenseRepo;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class DrivingLicenseRepoImpl extends AbstractRepository<DrivingLicense, String> implements DrivingLicenseRepo {
    @Override
    public Optional<DrivingLicense> findById(String s) throws Exception {
        TypedQuery<DrivingLicense> query = entityManager.createQuery("SELECT dl FROM DrivingLicense dl WHERE dl.id = :id", DrivingLicense.class);
        query.setParameter("id", s);
        return Optional.of(query.getSingleResult());
    }
}
