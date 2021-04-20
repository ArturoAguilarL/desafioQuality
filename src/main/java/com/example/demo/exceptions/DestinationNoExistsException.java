package com.example.demo.exceptions;

import com.example.demo.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class DestinationNoExistsException extends HotelException{
    public DestinationNoExistsException() {
        ErrorDTO error = new ErrorDTO();
        error.setName("Destination Does not exists");
        error.setDescription("Destination input invalid");
        this.setError(error);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
}

/*
        error.setName("Invalid Product Id");
        error.setDescription("No existe ese producto");
        this.setError(error);
        this.setStatus(HttpStatus.BAD_REQUEST);
 */
