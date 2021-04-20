package com.example.demo.utils;

import com.example.demo.dto.UserDTO;
import com.example.demo.exceptions.InvalidEmailException;
import com.example.demo.exceptions.InvalidPeopleAmountInput;

public class PersonValidator {


    public static void validatePerson(UserDTO u) throws InvalidPeopleAmountInput, InvalidEmailException {
        if(u.getDni() != null)
            validatePersonDNI(u.getDni());
        if(u.getName() != null)
            validateNamePerson(u.getName());
        if(u.getLastName() != null)
            validateLastNamePerson(u.getLastName());
        //if(u.getBirthdate() != null)
        if(u.getMail() != null)
            HotelUtils.validateEmail(u.getMail());

    }
    public static boolean validatePersonDNI(Object obj) throws InvalidPeopleAmountInput {
        if(HotelUtils.validateNumberOfPerson(obj))
            return true;
        else
            return false;

    }

    public static boolean validateNamePerson(Object obj){
        if(obj instanceof String)
            return true;
        //Meter una validacion con regex del nombre
        //devolver excepcion
        else
            return false;
    }

    public static boolean validateLastNamePerson(Object obj){
        if(obj instanceof String)
            return true;
            //Meter una validacion con regex del nombre
            //devolver excepcion
        else
            return false;
    }
}
