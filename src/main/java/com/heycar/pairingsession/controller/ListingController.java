package com.heycar.pairingsession.controller;

import com.heycar.pairingsession.model.Car;
import com.heycar.pairingsession.service.ListingService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListingController {
    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping("/listings/{dealerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadListing(@PathVariable int dealerId, @RequestBody @NotNull List<Car> cars) {
        cars.forEach(x -> x.setDealerId(dealerId));
        listingService.saveListing(cars);
    }

    @GetMapping("/listings")
    public ResponseEntity<Object> getAllListings() {
        return ResponseEntity.ok(listingService.getAllListings());
    }
}
