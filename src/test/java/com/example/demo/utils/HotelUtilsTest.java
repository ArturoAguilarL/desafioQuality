package com.example.demo.utils;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HotelUtilsTest {


    @Test
    public void validateEmailTest() throws InvalidEmailException {
        String mail = "lionelmessi@gmail.com";
        Assertions.assertEquals(HotelUtils.validateEmail(mail),true);
    }

    @Test
    public void validateEmailTestInvalidInputThrowsExceptionTest(){
        String mail = "";
        Assertions.assertThrows(InvalidEmailException.class, () -> HotelUtils.validateEmail(mail));
    }

    @Test
    public void validateHotelCodeTest(){
        //Realizar test una vez hecho el metodo de validar -> incomplete
        Assertions.assertEquals(HotelUtils.validateHotelCode("code"),true);
    }

    @Test
    public void validateNumberPersonsTest() throws InvalidPeopleAmountInput {
        Assertions.assertEquals(HotelUtils.validateNumberOfPerson(2),true);
    }

    @Test
    public void wrongInputOfNumberOfPersonsShouldThrowExceptionTest(){
        Assertions.assertThrows(InvalidPeopleAmountInput.class, () -> HotelUtils.validateNumberOfPerson("cinco"));
    }

    @Test
    public void validateTwoDatesInOrderTest() throws ParseException, CheckInGreaterThanCheckOutException, CheckOutBeforeCheckInException {
        String dateF = "16/04/2021";
        String dateT = "20/04/2021";
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateF);
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateT);

        Assertions.assertEquals(HotelUtils.validateDatesInOrder(date1,date2),true);
    }

    @Test
    public void twoDatesInDisorderShouldThrowException() throws ParseException {
        String dateF = "16/04/2021";
        String dateT = "20/04/2021";
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateF);
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateT);

        Assertions.assertThrows(CheckInGreaterThanCheckOutException.class, () -> HotelUtils.validateDatesInOrder(date2,date1));
    }

    @Test
    public void validateRoomTypeTest() throws InvalidRoomTypeException {
        Assertions.assertEquals(HotelUtils.validateRoomType("Doble",2),true);
    }

    @Test
    public void threePersonsInASingleRoomShouldThrowException(){
        Assertions.assertThrows(InvalidRoomTypeException.class, () -> HotelUtils.validateRoomType("Single",3));
    }

    @Test
    public void getAmountDayByDatesTest() throws ParseException {
       // Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2021");
       // Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("10/05/2021");

        Assertions.assertEquals(HotelUtils.getDaysByDates("01/05/2021","10/05/2021"),9);
    }

    @Test
    public void debitCardHasNoInterestTest(){
        PaymentDTO payment = new PaymentDTO();
        payment.setDues(5);
        payment.setType("DEBIT");
        payment.setNumber("1010-1010-1234-1235");

        Assertions.assertEquals(HotelUtils.calculateInterest(payment),0.0);
    }

    @Test
    public void creditCardWith3DuesHasInterestTest(){
        PaymentDTO payment = new PaymentDTO();
        payment.setDues(3);
        payment.setType("CREDIT");
        payment.setNumber("1010-1010-1234-1235");

        Assertions.assertEquals(HotelUtils.calculateInterest(payment),0.05);

    }

}
