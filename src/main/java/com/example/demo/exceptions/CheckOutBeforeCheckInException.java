package com.example.demo.exceptions;

import com.example.demo.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class CheckOutBeforeCheckInException extends HotelException{
    public CheckOutBeforeCheckInException(){
        ErrorDTO error = new ErrorDTO();
        error.setName("check-OUT date greater than check-out");
        error.setDescription("Invalid check-OUT Input");
        this.setError(error);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
}
