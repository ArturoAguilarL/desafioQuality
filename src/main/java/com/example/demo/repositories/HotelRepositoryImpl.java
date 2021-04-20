package com.example.demo.repositories;

import com.example.demo.dto.*;
import com.example.demo.utils.HotelUtils;
import com.example.demo.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class HotelRepositoryImpl implements HotelRepository{
    private static String filePathHotels = "src/main/resources/dbHotels.csv";
    private static Map<String, Integer>  destinations;
    List<HotelDTO> hotels;
    List<BookingDTO> bookings;

    public HotelRepositoryImpl(){
        this.hotels = parseHotelCSV(filePathHotels);
        this.destinations = new HashMap<>();
    }

    @Override
    public List<HotelDTO> getHotels(Date dateFrom, Date dateTo, String destination) {
        List<HotelDTO> hotelsListCopy = new ArrayList<>(this.hotels);
        hotelsListCopy.removeIf(p -> !p.getCity().equals(destination));
        hotelsListCopy.removeIf(p -> !(p.getDateFrom().before(dateFrom) | p.getDateFrom().equals(dateFrom)));
        hotelsListCopy.removeIf(p -> !(p.getDateTo().after(dateTo) | p.getDateTo().equals(dateTo)));
        return hotelsListCopy;
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        //List<HotelDTO> hotelsListCopy = new ArrayList<>(this.hotels);
        return this.hotels;
    }

    @Override
    public boolean destinationExists(String destination) {
        for(HotelDTO h : hotels){
            if(h.getCity().equals(destination)){
                return true;
            }
        }
        return false;
    }

    @Override
    public HotelResponsePayloadDTO generateBooking(HotelPayloadDTO payload) throws ParseException {
        HotelResponsePayloadDTO response = new HotelResponsePayloadDTO();
        response.setUserName(payload.getUserName());
        response.setBooking(payload.getBooking());
        HotelDTO hotel = getHotelByCode(payload.getBooking().getHotelCode());
        Double amount = HotelUtils.getDaysByDates(payload.getBooking().getDateFrom(),payload.getBooking().getDateTo()) * hotel.getNightPrice();
        response.setAmount(amount);
        Double interest = HotelUtils.calculateInterest(payload.getBooking().getPaymentMethod());
        response.setInterest((interest * 100));
        response.setTotal(amount + amount * interest);
        StatusDTO statusCode = new StatusDTO();
        statusCode.setCode(HttpStatus.OK.value());
        statusCode.setMessage(HttpStatus.OK.toString());
        response.setStatusCode(statusCode);
        return response;
    }


    private HotelDTO getHotelByCode(String hotelCode) {
        for(HotelDTO h : this.hotels){
            if(h.getCodeHotel().equals(hotelCode)){
                return h;
            }
        }
        return null;
    }

    public static List<HotelDTO> parseHotelCSV(String path){
        String splitBy = ",";
        String line = "";
        Integer contId = 1;
        Integer value = 0;
        List<HotelDTO> hotels = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null) {
                String[] pr = line.split(splitBy);
                HotelDTO hotel = new HotelDTO();
                hotel.setId(contId++);
                hotel.setCodeHotel(pr[0]);
                hotel.setName(pr[1]);
                hotel.setCity(pr[2]);
                hotel.setRoomType(pr[3]);
                hotel.setNightPrice(Double.valueOf(Utils.cleanPrice(pr[4])));
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                hotel.setDateFrom(dateFormat.parse(pr[5]));
                hotel.setDateTo(dateFormat.parse(pr[6]));
                hotel.setReserved(pr[7].equals("SI"));
                hotels.add(hotel);

            }
            br.close();
            return hotels;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return hotels;
    }

}
