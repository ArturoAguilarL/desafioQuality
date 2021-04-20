package com.example.demo.services;

import com.example.demo.dto.FlightDTO;

import java.util.List;

public interface FlightService {
    List<FlightDTO> getFlights();
}
