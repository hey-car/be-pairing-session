package com.heycar.pairingsession.repository;

import com.heycar.pairingsession.model.Listing;

import java.util.List;

public interface ListingsRepository {

    public void saveAll();

    public List<Listing> findAll();
}
