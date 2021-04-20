package com.example.demo.controllers;


import com.example.demo.dto.HotelDTO;
import com.example.demo.dto.HotelFixtureDTO;
import com.example.demo.exceptions.CheckInGreaterThanCheckOutException;
import com.example.demo.exceptions.CheckOutBeforeCheckInException;
import com.example.demo.exceptions.DateFormatInvalidException;
import com.example.demo.exceptions.DestinationNoExistsException;
import com.example.demo.services.HotelServiceImpl;
import com.example.demo.utils.DateUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(MockitoJUnitRunner.class)
@EnableWebMvc
public class HotelControllerTest {
    @InjectMocks
    private HotelController hotelController;

    @Mock
    private HotelServiceImpl hotelService;

    @Test
    public void getAllHotelsTest() throws CheckInGreaterThanCheckOutException, DateFormatInvalidException, CheckOutBeforeCheckInException, DestinationNoExistsException {
        List<HotelDTO> hotelList = Arrays.asList(HotelFixtureDTO.withDefaults1(),HotelFixtureDTO.withDefaults2());

        when(hotelService.getHotels(null,null,null)).thenReturn(hotelList);

        List<HotelDTO> result = hotelController.getHotels(null,null,null);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo(HotelFixtureDTO.withDefaults1().getName());
        assertThat(result.get(1).getName()).isEqualTo(HotelFixtureDTO.withDefaults2().getName());

    }

    @Test
    public void getHotelsWithFilters() throws Exception {
        HotelDTO hotel1 = new HotelDTO("CH-0002","Cataratas Hotel", "Puerto Iguazú","Doble",6300.0, LocalDate.of(2021, 02, 13),
                LocalDate.of(2021, 02, 20),false);
        HotelDTO hotel2 = new HotelDTO("SH-0002","Sheraton", "Buenos Aires","Doble",5790.0, LocalDate.of(2021, 02, 14),
                LocalDate.of(2021, 02, 20),false);

        List<HotelDTO> hotels = new ArrayList<>();
        hotels.add(hotel1);
        hotels.add(hotel2);

        when(hotelService.getHotels(any(), any(), any())).thenReturn(hotels);

        List<HotelDTO> response = hotelController.getHotels("12/02/2021", "25/02/21", "Buenos Aires");

        Assertions.assertEquals(hotels,response);
    }
}
