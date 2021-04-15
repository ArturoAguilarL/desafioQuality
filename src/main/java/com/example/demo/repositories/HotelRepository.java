package com.example.demo.repositories;

import com.example.demo.dto.HotelDTO;

import java.util.List;

public interface HotelRepository {
    List<HotelDTO> getHotels();
}
