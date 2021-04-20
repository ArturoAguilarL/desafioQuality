package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class FlightDTO {
    private Integer id;
    private String flightNumber;
    private String origin;
    private String destination;
    private String seatType;
    private Double price;
    private Date dateFrom;
    private Date dateTo;
}
