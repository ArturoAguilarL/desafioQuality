package com.example.demo.services;

import com.example.demo.dto.*;
import com.example.demo.exceptions.*;
import com.example.demo.repositories.HotelRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class HotelServiceTest {

    @Mock
    HotelRepositoryImpl hotelRepository;

    HotelServiceImpl hotelService;

    @BeforeEach
    void setUp(){
        openMocks(this);
        this.hotelService = new HotelServiceImpl(hotelRepository);
    }

    @Test
    public void getAllHotelsTest() throws CheckInGreaterThanCheckOutException, DateFormatInvalidException, CheckOutBeforeCheckInException, DestinationNoExistsException {
        List<HotelDTO> hotels = new ArrayList<>();
        when(hotelRepository.getAllHotels()).thenReturn(hotels);

        Assertions.assertEquals(hotels.size(),hotelService.getHotels(null,null,null).size());
    }

    /*
    @Test
    public void bookingProcessTest() throws ParseException, InvalidPeopleAmountInput, InvalidEmailException, DestinationNoExistsException, DateFormatInvalidException, InvalidRoomTypeException {
        HotelDTO hotel = new HotelDTO();
        hotel.setCodeHotel("BG-0004");
        hotel.setName("Bocagrande");
        hotel.setCity("Cartagena");
        hotel.setRoomType("Múltiple");
        hotel.setNightPrice(9370.0);
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("17/04/2021");
        hotel.setDateFrom(date1);
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("12/06/2021");
        hotel.setDateTo(date2);
        hotel.setReserved(false);


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
        booking.setPeople(users);
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

        HotelResponsePayloadDTO test = hotelService.processBooking(payload);

        Assertions.assertEquals(response,test);
    }
    */


}
