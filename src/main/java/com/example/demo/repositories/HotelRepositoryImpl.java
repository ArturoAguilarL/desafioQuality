package com.example.demo.repositories;

import com.example.demo.dto.HotelDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelRepositoryImpl implements HotelRepository{
    List<HotelDTO> hotels;

    public HotelRepositoryImpl(){
        this.hotels = loadHotelsDB();
    }

    @Override
    public List<HotelDTO> getHotels() {
        List<HotelDTO> hotelsListCopy = new ArrayList<>(this.hotels);
        return hotelsListCopy;
    }


    private List<HotelDTO> loadHotelsDB() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:dbHotels.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<HotelDTO>> typeRef = new TypeReference<List<HotelDTO>>() {};
        List<HotelDTO> caloriasDTOS = null;
        try {
            
            caloriasDTOS = objectMapper.readValue(file, typeRef);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return caloriasDTOS;

    }


}
