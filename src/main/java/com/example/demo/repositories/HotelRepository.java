package com.example.demo.repositories;

import com.example.demo.dto.HotelDTO;
import com.example.demo.dto.HotelParamDTO;
import com.example.demo.dto.HotelPayloadDTO;
import com.example.demo.dto.HotelResponsePayloadDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface HotelRepository {
    List<HotelDTO> getHotels(Date dateFrom, Date dateTo, String destination);

    List<HotelDTO> getAllHotels();

    boolean destinationExists(String destination);

    HotelResponsePayloadDTO generateBooking(HotelPayloadDTO payload) throws ParseException;

}
