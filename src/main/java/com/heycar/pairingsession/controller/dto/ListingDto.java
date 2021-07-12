package com.heycar.pairingsession.controller.dto;

import com.heycar.pairingsession.domain.Listing;
import lombok.Getter;

import java.util.List;

@Getter
public class ListingDto {

    private String code;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private Integer price;

}