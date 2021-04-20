package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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
}
