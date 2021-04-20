package com.example.demo.services;

import com.example.demo.dto.FlightBookingDTO;
import com.example.demo.dto.FlightBookingResponseDTO;
import com.example.demo.dto.FlightDTO;
import com.example.demo.exceptions.CheckInGreaterThanCheckOutException;
import com.example.demo.exceptions.CheckOutBeforeCheckInException;
import com.example.demo.exceptions.DateFormatInvalidException;

import java.util.List;

public interface FlightService {
    List<FlightDTO> getFlights(String dateFrom, String dateTo, String origin,String destination) throws DateFormatInvalidException, CheckInGreaterThanCheckOutException, CheckOutBeforeCheckInException;

    FlightBookingResponseDTO bookFlight(FlightBookingDTO book);
}
