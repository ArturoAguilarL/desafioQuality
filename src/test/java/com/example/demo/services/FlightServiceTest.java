package com.example.demo.services;

import com.example.demo.dto.FlightDTO;
import com.example.demo.dto.HotelDTO;
import com.example.demo.exceptions.CheckInGreaterThanCheckOutException;
import com.example.demo.exceptions.CheckOutBeforeCheckInException;
import com.example.demo.exceptions.DateFormatInvalidException;
import com.example.demo.exceptions.DestinationNoExistsException;
import com.example.demo.repositories.FlightRepository;
import com.example.demo.repositories.FlightRepositoryImpl;
import com.example.demo.repositories.HotelRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class FlightServiceTest {

    @InjectMocks
    private FlightServiceImpl flightService;
    @Mock
    FlightRepositoryImpl flightRepository;


    @BeforeEach
    void setUp(){
        openMocks(this);
        this.flightService = new FlightServiceImpl(flightRepository);
    }

    @Test
    public void getAllFlightsTest() throws CheckInGreaterThanCheckOutException, DateFormatInvalidException, CheckOutBeforeCheckInException, DestinationNoExistsException {
        List<FlightDTO> flights = new ArrayList<>();
        when(flightRepository.getAllFlights()).thenReturn(flights);

        Assertions.assertEquals(flights.size(),flightService.getFlights(null,null,null,null).size());
    }


    @Test
    public void bookAFlightTest(){

    }
}
