package com.heycar.pairingsession;

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
