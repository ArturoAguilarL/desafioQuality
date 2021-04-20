package com.example.demo.services;

import com.example.demo.dto.FlightDTO;
import com.example.demo.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<FlightDTO> getFlights() {
        return flightRepository.getFlights();
    }
}
