package com.heycar.pairingsession.service;

import com.heycar.pairingsession.repository.ListingsRepository;

public class ListingsService {
    private final ListingsRepository listingsRepository;

    public ListingsService(ListingsRepository listingsRepository) {
        this.listingsRepository = listingsRepository;
    }

    public void saveListings() {
        listingsRepository.saveAll();
    }

    public void findListings() {
        listingsRepository.findAll();
    }
}
