package com.example.demo.controllers;


import com.example.demo.dto.HotelDTO;
import com.example.demo.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping(value = "api/v1/hotels")
    public List<HotelDTO> getHotels(){
        System.out.println("GGGGGGGGGG");
        return hotelService.getHotels();
    }


}
