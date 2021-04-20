package com.example.demo.exceptions;

import com.example.demo.dto.ErrorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public abstract class HotelException extends Exception {
    private ErrorDTO error;
    private HttpStatus status;
}
