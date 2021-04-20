package com.example.demo.services;

import com.example.demo.dto.FlightBookingDTO;
import com.example.demo.dto.FlightBookingResponseDTO;
import com.example.demo.dto.FlightDTO;
import com.example.demo.exceptions.CheckInGreaterThanCheckOutException;
import com.example.demo.exceptions.CheckOutBeforeCheckInException;
import com.example.demo.exceptions.DateFormatInvalidException;
import com.example.demo.repositories.FlightRepository;
import com.example.demo.repositories.FlightRepositoryImpl;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.HotelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepositoryImpl flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<FlightDTO> getFlights(String dateFrom, String dateTo, String origin,String destination) throws DateFormatInvalidException, CheckInGreaterThanCheckOutException, CheckOutBeforeCheckInException {
        Date dateF = null;
        Date dateT = null;
        if(dateFrom == null && dateTo == null && destination == null && origin == null){
            return flightRepository.getAllFlights();
        }
        if(dateFrom != null){
            dateF = DateUtils.convertStringToDate(dateFrom);
        }
        if(dateTo != null){
            dateT = DateUtils.convertStringToDate(dateTo);
        }
        if(destination != null){
            flightRepository.destinationExists(destination);
        }
        if(origin != null){
            flightRepository.originExists(origin);
        }
        if(HotelUtils.validateDatesInOrder(dateF,dateT)){
            return flightRepository.getFlights(dateF,dateT,origin,destination);
        }
        return null;
    }

    @Override
    public FlightBookingResponseDTO bookFlight(FlightBookingDTO book) {
        return null;
    }
}
