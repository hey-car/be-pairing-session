package com.heycar.pairingsession.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Builder
@Getter
@Setter
@Entity(name="listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String dealerId;
    private String code;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private Integer price;
}
