package com.example.demo.services;


import com.example.demo.dto.*;
import com.example.demo.exceptions.*;
import com.example.demo.repositories.HotelRepository;
import com.example.demo.repositories.HotelRepositoryImpl;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.HotelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepositoryImpl hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<HotelDTO> getHotels(String dateFrom, String dateTo, String destination) throws DestinationNoExistsException, CheckInGreaterThanCheckOutException, DateFormatInvalidException, CheckOutBeforeCheckInException {
        Date dateF = null;
        Date dateT = null;
        if(dateFrom == null && dateTo == null && destination == null){
            System.out.println("No tiene filtros");
            return hotelRepository.getAllHotels();
        }
        if(dateFrom != null){
            dateF = DateUtils.convertStringToDate(dateFrom);
        }
        if(dateTo != null){
            dateT = DateUtils.convertStringToDate(dateTo);
        }
        if(destination != null){
            validateDestinationParam(destination);
        }
        if(HotelUtils.validateDatesInOrder(dateF,dateT)){
            return hotelRepository.getHotels(dateF,dateT,destination);
        }
        return null;
    }


    @Override
    public HotelResponsePayloadDTO processBooking(HotelPayloadDTO payload) throws InvalidEmailException, InvalidPeopleAmountInput, DateFormatInvalidException, DestinationNoExistsException, InvalidRoomTypeException, ParseException {
        if(payload.getUserName() != null){
            HotelUtils.validateEmail(payload.getUserName());
        }
        if(payload.getBooking() != null){
            validateBooking(payload.getBooking());
        }
        //HotelValidator.validateEmail(payload.getBooking().getPeople());
        return hotelRepository.generateBooking(payload);
    }


    private boolean validateBooking(BookingDTO booking) throws DateFormatInvalidException, DestinationNoExistsException, InvalidPeopleAmountInput, InvalidRoomTypeException, InvalidEmailException {
        Date dateF = null;
        Date dateT = null;
        if(booking.getDateFrom() != null)
            dateF = DateUtils.convertStringToDate(booking.getDateFrom());
        if(booking.getDateTo() != null)
            dateT = DateUtils.convertStringToDate(booking.getDateTo());
        if(booking.getDestination() != null)
            validateDestinationParam(booking.getDestination());
        if(booking.getHotelCode() != null)
            HotelUtils.validateHotelCode(booking.getHotelCode());
        if(booking.getPeopleAmount() != null)
            HotelUtils.validateNumberOfPerson(booking.getPeopleAmount());
        if(booking.getRoomType() != null)
            HotelUtils.validateRoomType(booking.getRoomType(),booking.getPeopleAmount());
        /*if(booking.getPeople() != null){
            for(UserDTO u : booking.getPeople()){
                PersonValidator.validatePerson(u);
            }
        }*/
        /*
        if(booking.getPaymentMethod() != null){
            HotelUtils.validatePayment(booking.getPaymentMethod());
        }*/

        return true;
    }

    private boolean validateDatesInOrder(Date dateF, Date dateT) throws CheckInGreaterThanCheckOutException, CheckOutBeforeCheckInException {
        boolean result = false;
        if(dateF.before(dateT)){
            result = true;
        } else
            throw new CheckInGreaterThanCheckOutException();
        if(!dateT.before(dateT)){
            result = true;
        } else
            throw new CheckOutBeforeCheckInException();
        return result;
    }

    private void validateDestinationParam(String dest) throws DestinationNoExistsException {
        if(hotelRepository.destinationExists(dest)){
            System.out.println("Existe el destino");
            return;
        }else{
            throw new DestinationNoExistsException();
        }
    }



}
