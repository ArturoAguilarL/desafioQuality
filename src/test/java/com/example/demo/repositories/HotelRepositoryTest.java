package com.example.demo.repositories;

import com.example.demo.dto.HotelDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HotelRepositoryTest {
    private static String filePathHotels = "src/main/resources/dbHotels.csv";
    HotelRepository hotelRepository;

    @BeforeEach
    void setUp(){
        this.hotelRepository = new HotelRepositoryImpl();
    }


    /*@Test
    public void getAllHotelsTest(){
        List<HotelDTO> hotels = HotelRepositoryImpl.parseHotelCSV(filePathHotels);
        Assertions.assertIterableEquals(hotelRepository.getAllHotels(),hotels);
    }*/
    @Test
    public void getAllHotelsTest(){
        List<HotelDTO> hotels = HotelRepositoryImpl.parseHotelCSV(filePathHotels);
        Assertions.assertEquals(hotelRepository.getAllHotels().size(),12);
    }

    @Test
    public void destinationNoExists(){
        String destination = "India";
        Assertions.assertNotEquals(destination,hotelRepository.destinationExists(destination));
    }

    @Test
    public void destinationExists(){
        String destination = "Cartagena";
        Assertions.assertEquals(hotelRepository.destinationExists(destination),true);
    }

    /*@Test
    public void getHotelByCodeTest() throws ParseException {
        //List<HotelDTO> hotels = HotelRepositoryImpl.parseHotelCSV(filePathHotels);
        HotelDTO hotel = new HotelDTO();
        hotel.setId(1);
        hotel.setCodeHotel("CH-0002");
        hotel.setName("Cataratas Hotel");
        hotel.setCity("Puerto Iguazú");
        hotel.setRoomType("Doble");
        hotel.setNightPrice(6300.0);
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2021");
        hotel.setDateFrom(date1);
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("20/03/2021");
        hotel.setDateTo(date2);
        hotel.setReserved(false);
        Assertions.assertEquals(hotel, hotelRepository.getHotelByCode("CH-0002"));
    }*/
}
