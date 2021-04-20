package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
    private String type;
    private String number;
    private Integer dues;
}
