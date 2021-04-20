package com.example.demo.repositories;

import com.example.demo.dto.FlightDTO;

import java.util.List;

public interface FlightRepository {
    List<FlightDTO> getFlights();
}
