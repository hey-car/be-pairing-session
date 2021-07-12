package com.heycar.pairingsession.repository;

import com.heycar.pairingsession.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface ListingJpaRepository extends CrudRepository<Listing, String> {
    List<Listing> findAllListings();
}
