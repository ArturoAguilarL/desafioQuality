package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelResponsePayloadDTO{
    private String userName;
    private Double amount;
    private Double interest;
    private Double total;
    BookingDTO booking;
    StatusDTO statusCode;
}
