package com.example.demo.controllers;

import com.example.demo.dto.FlightBookingDTO;
import com.example.demo.dto.FlightDTO;
import com.example.demo.exceptions.CheckInGreaterThanCheckOutException;
import com.example.demo.exceptions.CheckOutBeforeCheckInException;
import com.example.demo.exceptions.DateFormatInvalidException;
import com.example.demo.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping(value = "api/v1/flights")
    public ResponseEntity getFlights(@RequestParam(value = "dateFrom", required = false) String dateFrom,
                                    @RequestParam(value = "dateTo", required = false) String dateTo,
                                    @RequestParam(value = "origin",required = false) String origin,
                                    @RequestParam(value = "destination", required = false) String destination) throws CheckOutBeforeCheckInException, CheckInGreaterThanCheckOutException, DateFormatInvalidException {
        //Capa de validacion
        return new ResponseEntity(flightService.getFlights(dateFrom,dateTo,origin,destination), HttpStatus.OK);
    }


    @PostMapping(value = "api/v1/flight-reservation")
    public ResponseEntity bookFlight(@RequestBody FlightBookingDTO book){
        return new ResponseEntity(flightService.bookFlight(book), HttpStatus.CREATED);
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