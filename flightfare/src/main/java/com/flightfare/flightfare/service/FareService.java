package com.flightfare.flightfare.service;



import com.flightfare.flightfare.model.Fare;
import com.flightfare.flightfare.model.FlightFare;

import java.util.Optional;

public interface FareService {

    FlightFare getfare();

    Fare setfare(Fare fare);

    Optional<Fare> getfare(String flightid);
}
