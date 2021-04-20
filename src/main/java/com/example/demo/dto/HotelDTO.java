package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class HotelDTO {
    private Integer id;
    private String codeHotel;
    private String name;
    private String city;
    private String roomType;
    private Double nightPrice;
    private Date dateTo;
    private Date dateFrom;
    private Boolean reserved;

    public HotelDTO(String code, String name, String province, String type, Double price, LocalDate availableSince, LocalDate availableUntil, Boolean isReserved) {
    }
}
