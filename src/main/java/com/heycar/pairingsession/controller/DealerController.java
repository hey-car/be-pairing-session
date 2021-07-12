package com.heycar.pairingsession.controller;

import com.heycar.pairingsession.controller.dto.ListingDto;
import com.heycar.pairingsession.service.DealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DealerController {

    private DealerService dealerService;

    @PostMapping("/listings/{dealerId}")
    public void getListings(@PathVariable String dealerId,
            @RequestBody List<ListingDto> listingResourceList) {
        dealerService.saveListings(dealerId, listingResourceList);
    }
}