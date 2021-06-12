package com.flight.flightsearch.exception;

public class FlightNotFoundException extends RuntimeException {
   private static final long serialVersionUID =1l;
   public FlightNotFoundException() {
   }

   public FlightNotFoundException(String message) {
      super(message);
   }

}
