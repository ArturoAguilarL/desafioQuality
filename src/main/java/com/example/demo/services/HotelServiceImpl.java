package com.example.demo.services;


import com.example.demo.dto.HotelDTO;
import com.example.demo.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<HotelDTO> getHotels() {
        return hotelRepository.getHotels();
    }
}
