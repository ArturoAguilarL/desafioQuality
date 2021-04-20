package com.example.demo.utils;

import com.example.demo.exceptions.DateFormatInvalidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilsTest {


    @Test
    public void convertStringToDateTest() throws ParseException, DateFormatInvalidException {
        String date1 = "18/04/2021";
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
        Assertions.assertEquals(date,DateUtils.convertStringToDate("18/04/2021"));
    }

    @Test
    public void convertStringToDateInvalidFormatShouldThrowExceptionTest() throws ParseException {
        String date1 = "18/04/2021";
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
        Assertions.assertThrows(DateFormatInvalidException.class, () -> DateUtils.convertStringToDate("18-04-2021"));
    }
}
