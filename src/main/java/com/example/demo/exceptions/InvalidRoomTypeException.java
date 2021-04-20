package com.example.demo.exceptions;

import com.example.demo.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class InvalidRoomTypeException extends HotelException{
    public InvalidRoomTypeException(){
        ErrorDTO error = new ErrorDTO();
        error.setName("Invalid room type");
        error.setDescription("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella");
        this.setError(error);
        this.setStatus(HttpStatus.BAD_REQUEST);
    }
}
