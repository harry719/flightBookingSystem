package com.flight.flightsearch.service;


import com.flight.flightsearch.exception.FlightNotFoundException;
import com.flight.flightsearch.exception.FlightNumberNotFoundException;
import com.flight.flightsearch.model.FlightSearch;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    FlightSearch save(FlightSearch flightSearch);


     List<FlightSearch> getFligts();

    Optional<FlightSearch> searchById(String flightNumber) throws FlightNumberNotFoundException;

    List<FlightSearch> bookflight(String source,String destination,String date) throws FlightNotFoundException;



}
