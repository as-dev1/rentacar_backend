package com.rent.rentacar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rent.rentacar.entity.CarType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CarModel {
    private Integer id;
    private String brand;
    private String model;
    private CarType type;
    private int year;

    @JsonProperty("number_of_seats")
    private int numberOfSeats;
    private int hp;
    private String description;

    @JsonProperty("price_per_day")
    private double pricePerDay;

    @JsonProperty("img_path")
    private String imgPath;
}
