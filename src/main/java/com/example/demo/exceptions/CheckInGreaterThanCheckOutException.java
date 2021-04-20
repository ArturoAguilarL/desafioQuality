package com.example.demo.exceptions;

import com.example.demo.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class CheckInGreaterThanCheckOutException extends HotelException {
    public CheckInGreaterThanCheckOutException(){
        ErrorDTO error = new ErrorDTO();
        error.setName("check-in date greater than check-out");
        error.setDescription("Invalid check-in Input");
        this.setError(error);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
}
