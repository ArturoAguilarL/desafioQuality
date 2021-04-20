package com.example.demo.exceptions;

import com.example.demo.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class InvalidPeopleAmountInput extends HotelException{
    public InvalidPeopleAmountInput(){
        ErrorDTO error = new ErrorDTO();
        error.setName("Invalid people amount input");
        error.setDescription("Error");
        this.setError(error);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
}
