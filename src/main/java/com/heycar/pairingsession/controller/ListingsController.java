package com.heycar.pairingsession.controller;

import com.heycar.pairingsession.service.ListingsService;

public class ListingsController {

    private final ListingsService listingsService;

    public ListingsController(ListingsService listingsService) {
        this.listingsService = listingsService;
    }

    /** Should accept the following request:
     curl -X POST 'http://localhost:8080/listings/{dealerId}/' \
         -H 'content-type: application/json' \
         -H 'accept: application/json' \
         --data-raw '
           [
             {
               "code": "a",
               "make": "volkswagen",
               "model": "golf",
               "year": 2018,
               "color": "red",
               "price": 13990
             }
           ]'

     Response: 200 OK, no body
     */
    public void saveListings() {
        listingsService.saveListings();
    }

    /** Should accept the following request:
     curl 'http://localhost:8080/listings' \
        -H 'accept: application/json'

     Response: 200 OK, body:
       {
         [
           "id: "listing1"
           "code": "a",
           "make": "volkswagen",
           "model": "golf",
           "year": 2018,
           "color": "red",
           "price": 13990
         ]
       }
     */
    public void searchListings() {
        listingsService.findListings();
    }

}
