package com.example.demo.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    public void cleanAPriceShouldReturnAStringCleanTest(){
        String price = "$6.300";
        Assertions.assertEquals("6300",Utils.cleanPrice(price));
    }


}
