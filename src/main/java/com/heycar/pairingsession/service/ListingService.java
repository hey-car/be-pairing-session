package com.heycar.pairingsession.service;

import com.heycar.pairingsession.model.Car;
import com.heycar.pairingsession.repository.ListingRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {
    private final ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public void saveListing(@NotNull List<Car> cars) {
        listingRepository.saveAll(cars);
    }

    public List<Car> getAllListings() {
        return listingRepository.findAll();
    }
}
