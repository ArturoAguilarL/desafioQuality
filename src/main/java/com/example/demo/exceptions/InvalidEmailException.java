package com.example.demo.exceptions;

import com.example.demo.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class InvalidEmailException extends HotelException {
    public void InvalidEmailException(){
        ErrorDTO error = new ErrorDTO();
        error.setName("Invalid email format");
        error.setDescription("Error");
        this.setError(error);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
}
