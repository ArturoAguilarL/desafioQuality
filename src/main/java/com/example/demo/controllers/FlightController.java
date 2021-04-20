package com.example.demo.controllers;

import com.example.demo.dto.FlightDTO;
import com.example.demo.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping(value = "api/v1/f")
    public List<FlightDTO> getFlights(){
        return flightService.getFlights();
    }
}


/*
    @Autowired
    HotelService hotelService;

    @GetMapping(value = "api/v1/hotels")
    public List<HotelDTO> getHotels(){
        return hotelService.getHotels();
    }
 */