package com.heycar.pairingsession.repository;

import com.heycar.pairingsession.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ListingJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Listing listing) {
        entityManager.persist(listing);
    }
}
