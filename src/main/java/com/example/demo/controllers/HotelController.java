package com.example.demo.controllers;


import com.example.demo.dto.*;
import com.example.demo.exceptions.*;
import com.example.demo.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping(value = "api/v1/hotels")
    public List<HotelDTO> getHotels(@RequestParam(value = "dateFrom", required = false) String dateFrom,
                                    @RequestParam(value = "dateTo", required = false) String dateTo,
                                    @RequestParam(value = "destination", required = false) String destination) throws DestinationNoExistsException, CheckInGreaterThanCheckOutException, CheckOutBeforeCheckInException, DateFormatInvalidException {
        return hotelService.getHotels(dateFrom, dateTo, destination);
    }

    @PostMapping(value = "api/v1/booking")
    public HotelResponsePayloadDTO booking(@RequestBody HotelPayloadDTO payload) throws InvalidPeopleAmountInput, InvalidEmailException, DestinationNoExistsException, DateFormatInvalidException, InvalidRoomTypeException, ParseException {
        return hotelService.processBooking(payload);
    }


    @ExceptionHandler(HotelException.class)
    public ResponseEntity<ErrorDTO> handleException(HotelException exception){
        return new ResponseEntity<>(exception.getError(),exception.getStatus());
    }

}
