package com.rent.rentacar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;
}
