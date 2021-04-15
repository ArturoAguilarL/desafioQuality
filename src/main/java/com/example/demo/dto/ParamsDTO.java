package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ParamsDTO {
    private String name;
    private String category;
    private String brand;
    private Double price;
    private Integer quantity;
    private Boolean freeShipping;
    private Integer prestige;
    private Integer order;
}
