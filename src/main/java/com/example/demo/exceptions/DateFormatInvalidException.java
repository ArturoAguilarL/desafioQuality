package com.example.demo.exceptions;

import com.example.demo.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class DateFormatInvalidException extends HotelException{
    public DateFormatInvalidException(){
        ErrorDTO error = new ErrorDTO();
        error.setName("Invalid Date format");
        error.setDescription("Error");
        this.setError(error);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
}
