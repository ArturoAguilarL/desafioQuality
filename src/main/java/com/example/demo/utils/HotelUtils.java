package com.example.demo.utils;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.exceptions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelUtils {
    private static String emailPatternValidation = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    /**
     *
     * @param email
     * @return
     * @throws InvalidEmailException
     */
    public static boolean validateEmail(String email) throws InvalidEmailException {
        Pattern pattern = Pattern.compile(emailPatternValidation);
        Matcher regularExp = pattern.matcher(email);
        if (regularExp.find())
            return true;
        else
            throw new InvalidEmailException();
    }

    public static boolean validateHotelCode(String code){
        //Validar los codigos de hotel : ej: "CC-0002"
        return true;
    }

    public static boolean validateNumberOfPerson(Object obj) throws InvalidPeopleAmountInput {
        if (obj instanceof Integer)
            return true;
        else
            throw new InvalidPeopleAmountInput();

    }


    /**
     *
     * @param dateF
     * @param dateT
     * @return
     * @throws CheckInGreaterThanCheckOutException
     * @throws CheckOutBeforeCheckInException
     */
    public static boolean validateDatesInOrder(Date dateF, Date dateT) throws CheckInGreaterThanCheckOutException, CheckOutBeforeCheckInException {
        boolean result = false;
        if (dateF.before(dateT)) {
            result = true;
        } else
            throw new CheckInGreaterThanCheckOutException();
        if (!dateT.before(dateT)) {
            result = true;
        } else
            throw new CheckOutBeforeCheckInException();
        return result;
    }

    public static boolean validateRoomType(String roomType, Integer peopleAmount) throws InvalidRoomTypeException {
        //No sé porque no me deja usar ternario.
        //Seria return (peopleAmount == 1) ? true : throw new InvalidRoomTypeException();
        switch (roomType){
            case "Single":
                if(peopleAmount == 1)
                    return true;
                else
                    throw new InvalidRoomTypeException();
            case "Doble":
                if(peopleAmount <= 2)
                    return true;
                else
                    throw new InvalidRoomTypeException();

            case "Triple":
                if(peopleAmount <= 3)
                    return true;
                else
                    throw new InvalidRoomTypeException();
            case "Multiple":
                if(peopleAmount <= 4)
                    return true;
                else
                    throw new InvalidRoomTypeException();
        }
        return false;
    }

    /*
    public static void validatePayment(PaymentDTO paymentMethod) {
       return;
    }*/


    public static Integer getDaysByDates(String dateFrom, String dateTo) throws ParseException {
        //El repository no deberia lanzar un exp de parseo
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateFrom);
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateTo);
        long diff = date2.getTime() - date1.getTime();
        return Math.toIntExact((TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)));
    }

    public static Double calculateInterest(PaymentDTO paymentMethod) {
        Double result = 0.0;
        switch (paymentMethod.getType()){
            case "CREDIT":
                result = processCreditCardInterest(paymentMethod);
                return result;
            case "DEBIT":
                return result;
            default:
                //Excepcion
        }
        return result;
    }

    public static Double processCreditCardInterest(PaymentDTO paymentMethod) {
        int dues = paymentMethod.getDues();
        if (dues == 1) {
            return 0.0;
        } else if (dues == 2 | dues == 3) {
            return 0.05;
        } else if (dues >= 4 & dues <= 6) {
            return 0.1;
        } else if (dues >= 7 & dues <= 9) {
            return 0.15;
        } else if (dues >= 10 & dues <= 12) {
            return 0.2;
        } else{
            //Excepcion
            return 0.0;
        }

    }
}
