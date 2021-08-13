package com.heycar.pairingsession.model;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    public String getCode() {
        return code;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int id) {
        this.dealerId = id;
    }

    private int dealerId;
    private final String code;
    private final String make;
    private final int year;
    private final String color;
    private final int price;

    public Car(){}

    public Car(@NotNull String code, @NotNull String make, int year, @NotNull String color, int price) {
        this.code = code;
        this.make = make;
        this.year = year;
        this.color = color;
        this.price = price;
    }


}
