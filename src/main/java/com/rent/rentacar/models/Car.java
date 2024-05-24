package com.rent.rentacar.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

enum CarType {
    LUXURY,
    SPORT,
    ELECTRIC,
    SUV,
    CONVERTIBLE
}

@Entity(name = "car")
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Enumerated(EnumType.STRING)
    private CarType type;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    @JsonProperty("number_of_seats")
    private int numberOfSeats;

    @Column(nullable = false)
    private int hp;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    @JsonProperty("price_per_day")
    private double pricePerDay;

    @Column(nullable = false)
    @JsonProperty("img_path")
    private String imgPath;
}
