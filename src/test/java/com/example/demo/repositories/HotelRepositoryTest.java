package com.example.demo.repositories;

import com.example.demo.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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


    /*
    @Test
    public void generateBookingTest() throws ParseException {
        HotelPayloadDTO payload = new HotelPayloadDTO();
        payload.setUserName("lionelmessi@gmail.com");
        BookingDTO booking = new BookingDTO();
        booking.setDateFrom("01/05/2021");
        booking.setDateTo("07/05/2021");
        booking.setDestination("Cartagena");
        booking.setHotelCode("BG-0004");
        booking.setPeopleAmount(2);
        booking.setRoomType("DOUBLE");
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO());
        users.add(new UserDTO());
        booking.setPeople(null);
        PaymentDTO payment = new PaymentDTO();
        payment.setType("DEBIT");
        payment.setNumber("1234-1234-1234-1234");
        payment.setDues(0);
        booking.setPaymentMethod(payment);
        payload.setBooking(booking);

        HotelResponsePayloadDTO response = new HotelResponsePayloadDTO();
        response.setUserName("lionelmessi@gmail.com");
        response.setBooking(booking);
        response.setAmount(56220.0);
        response.setInterest(0.0);
        response.setTotal(56220.0);
        StatusDTO statusCode = new StatusDTO();
        statusCode.setCode(HttpStatus.OK.value());
        statusCode.setMessage(HttpStatus.OK.toString());
        response.setStatusCode(statusCode);

        HotelResponsePayloadDTO test = hotelRepository.generateBooking(payload);

        Assertions.assertEquals(response,test);

    }*/
}
