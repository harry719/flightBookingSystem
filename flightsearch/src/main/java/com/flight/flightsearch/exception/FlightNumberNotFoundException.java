package com.flight.flightsearch.exception;

public class FlightNumberNotFoundException extends RuntimeException {
    private static final long serialVersionUID =1l;

    public FlightNumberNotFoundException() {
    }

    public FlightNumberNotFoundException(String message) {
        super(message);
    }
}
