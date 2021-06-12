package com.flight.flightsearch.model;

import java.util.List;

public class FlightFare {

    private List<Fare> flightFare;

    public FlightFare(List<Fare> flightFare) {
        this.flightFare = flightFare;
    }

    public FlightFare() {
    }

    public List<Fare> getFlightFare() {
        return flightFare;
    }

    public void setFlightFare(List<Fare> flightFare) {
        this.flightFare = flightFare;
    }
}
