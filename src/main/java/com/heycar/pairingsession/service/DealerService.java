package com.heycar.pairingsession.service;

import com.heycar.pairingsession.controller.dto.ListingDto;
import com.heycar.pairingsession.domain.Listing;
import com.heycar.pairingsession.repository.ListingJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealerService {

    private final ListingJpaRepository listingJpaRepository;

    public void saveListings(String dealerId, List<ListingDto> listingResourceList) {
        listingResourceList.stream().forEach(listingDto -> {
            listingJpaRepository.save(Listing.builder()
                    .dealerId(dealerId)
                    .code(listingDto.getCode())
                    .color(listingDto.getColor())
                    .make(listingDto.getMake())
                    .model(listingDto.getModel())
                    .price(listingDto.getPrice())
                    .year(listingDto.getYear())
                    .build());
        });
    }
}
