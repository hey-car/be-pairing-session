package com.heycar.pairingsession.repository;


import com.heycar.pairingsession.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends CrudRepository<Car, Long> {
    List<Car> findAll();
}
