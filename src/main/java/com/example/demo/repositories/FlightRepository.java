package com.example.demo.repositories;

import com.example.demo.dto.FlightDTO;

import java.util.Date;
import java.util.List;

public interface FlightRepository {
    public List<FlightDTO> getAllFlights();

    void destinationExists(String destination);

    void originExists(String origin);

    List<FlightDTO> getFlights(Date dateF, Date dateT, String origin, String destination);
}
