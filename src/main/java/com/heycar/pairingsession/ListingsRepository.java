package com.heycar.pairingsession;

import java.util.List;

public interface ListingsRepository {

    void saveAll();

    List<Listing> findAll();
}
