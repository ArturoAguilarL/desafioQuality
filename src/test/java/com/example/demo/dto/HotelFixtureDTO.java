package com.example.demo.dto;

import java.time.LocalDate;

public class HotelFixtureDTO {
    public static final String code = "CH-0002";
    public static final String name = "Cataratas Hotel";
    public static final String province = "Puerto Iguazú";
    public static final String type = "Doble";
    public static final Double price = 6300.0;
    public static final LocalDate availableSince = LocalDate.of(2021, 1, 1);
    public static final LocalDate availableUntil = LocalDate.of(2021, 2, 1);
    public static final Boolean isReserved = false;


    public static HotelDTO withDefaults1() {
        return new HotelDTO(code, name, province, type, price, availableSince, availableUntil, isReserved);
    }

    public static HotelDTO withDefaults2()
    {
        return new HotelDTO("HB-0001",
                "Hotel Bristol",
                "Buenos Aires",
                "Single",
                5435.0,
                LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 2, 1),
                false);
    }
}