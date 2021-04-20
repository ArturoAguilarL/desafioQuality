package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@Data
public class HotelParamDTO {
    private static final HotelParamDTO EMPTY = new HotelParamDTO();
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", lenient = OptBoolean.FALSE, timezone = "America/Buenos_Aires")
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dateFrom;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", lenient = OptBoolean.FALSE, timezone = "America/Buenos_Aires")
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dateTo;
    private String destination;

   /* public boolean isEmpty(){
        return this.equals(EMPTY);
    }*/

}
