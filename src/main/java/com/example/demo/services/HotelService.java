package com.example.demo.services;

import com.example.demo.dto.HotelDTO;
import com.example.demo.dto.HotelParamDTO;
import com.example.demo.dto.HotelPayloadDTO;
import com.example.demo.dto.HotelResponsePayloadDTO;
import com.example.demo.exceptions.*;

import java.text.ParseException;
import java.util.List;

public interface HotelService {
    List<HotelDTO> getHotels(String dateFrom, String dateTo, String destination) throws DestinationNoExistsException, CheckInGreaterThanCheckOutException, DateFormatInvalidException, CheckOutBeforeCheckInException;

    HotelResponsePayloadDTO processBooking(HotelPayloadDTO payload) throws InvalidEmailException, InvalidPeopleAmountInput, DateFormatInvalidException, DestinationNoExistsException, InvalidRoomTypeException, ParseException;
}
