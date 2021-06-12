package com.flight.flightsearch.service;


import com.flight.flightsearch.exception.FlightNotFoundException;
import com.flight.flightsearch.exception.FlightNumberNotFoundException;
import com.flight.flightsearch.model.Fare;
import com.flight.flightsearch.model.FlightFare;
import com.flight.flightsearch.model.FlightSearch;
import com.flight.flightsearch.repository.FlightSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightSearchRepository flightSearchRepository;

    @Autowired
    RestTemplate getRestTemplate;
    Logger logger = LoggerFactory.getLogger(FlightSearch.class);


    @Override
    public List<FlightSearch> getFligts() {
        logger.info("In getFlights()");
        var fare = getRestTemplate.getForObject("http://flight-fare/fare/flightfare", FlightFare.class);
        var farelist = fare.getFlightFare().stream().map(id -> id.getFlightid()).collect(Collectors.toList());
        for (var flight : this.flightSearchRepository.findAll()) {
            {
                var index = flight.getId();
                flight.setFare(fare.getFlightFare().get(index-1).getFlightfare());

            }
        }
        return this.flightSearchRepository.findAll();

    }

    @Override
    public FlightSearch save(FlightSearch flightSearch) {
        logger.info("saving detials of flight to database");
        return this.flightSearchRepository.save(flightSearch);
    }


    @Override
    public List<FlightSearch> bookflight(String source, String destination, String date) {
        List<FlightSearch> flightSearchList = new ArrayList<>();
        var fare = getRestTemplate.getForObject("http://flight-fare/fare/flightfare", FlightFare.class);
        var farelist = fare.getFlightFare().stream().map(id -> id.getFlightid()).collect(Collectors.toList());
        System.out.println(farelist);
        for (var flight : this.flightSearchRepository.findAll()) {
            if (source.equals(flight.getSource())
                    && destination.equals(flight.getDestination())
                    && date.equals(flight.getDate())
                    && farelist.contains(flight.getFlightNumber())) {
                var index = flight.getId();
                flight.setFare(fare.getFlightFare().get(index - 1).getFlightfare());
                flightSearchList.add(flight);
            }
        }
        System.out.println("Send msg.. = " + flightSearchList);
        logger.info("searched flight for specific details");
        if (flightSearchList.isEmpty()) {
            throw new FlightNotFoundException("Flight Not Found");
        }
        return flightSearchList;

    }


    @Override
    public Optional<FlightSearch> searchById(String flightNumber) {
        logger.info("In searchById()");
        Optional<FlightSearch> flight = this.flightSearchRepository.findById(flightNumber);
        var fare = this.getRestTemplate.getForObject("http://flight-fare/fare/" + flightNumber, Fare.class);
        System.out.println(fare);
      if( flight.get().getFlightNumber().equals(flightNumber)){

               System.out.println(flight);
               flight.get().setFare((fare.getFlightfare()));
           }
            else
           {
               throw new FlightNumberNotFoundException("Invalid flight number");
           }
        System.out.println(flight);
        return flight;




}}