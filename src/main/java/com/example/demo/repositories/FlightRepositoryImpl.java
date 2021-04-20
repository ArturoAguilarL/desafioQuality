package com.example.demo.repositories;


import com.example.demo.dto.FlightDTO;
import com.example.demo.dto.HotelDTO;
import com.example.demo.utils.Utils;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Repository
public class FlightRepositoryImpl implements FlightRepository{
    List<FlightDTO> flights;

    public FlightRepositoryImpl(){
        this.flights = parseFlightsCSV();
    }


    @Override
    public List<FlightDTO> getAllFlights() {
        List<FlightDTO> flightsCopy = new ArrayList<>(this.flights);
        return flightsCopy;
    }

    @Override
    public void destinationExists(String destination) {

    }

    @Override
    public void originExists(String origin) {

    }

    @Override
    public List<FlightDTO> getFlights(Date dateF, Date dateT, String origin, String destination) {
        return null;
    }

    private List<FlightDTO> parseFlightsCSV() {
        String splitBy = ",";
        String line = "";
        Integer contId = 1;
        List<FlightDTO> flights = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/dbFligths.csv"));
            while((line = br.readLine()) != null) {
                String[] pr = line.split(splitBy);
                FlightDTO flight = new FlightDTO();
                flight.setId(contId++);
                flight.setFlightNumber(pr[0]);
                flight.setOrigin(pr[1]);
                flight.setDestination(pr[2]);
                flight.setSeatType(pr[3]);
                flight.setPrice(Double.valueOf(Utils.cleanPrice(pr[4])));
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                flight.setDateFrom(dateFormat.parse(pr[5]));
                flight.setDateTo(dateFormat.parse(pr[6]));
                flights.add(flight);
            }
            br.close();
            return flights;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
