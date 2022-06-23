package com.flight.flightsearch.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = FlightSearch.class)
@Document(collection = "flightsearch")
@EntityScan
public class FlightSearch {


    private Integer id;
     @NotBlank(message = "source city cannot be null")
     @Size(min = 3,max = 3)
    private String source;
    @NotBlank(message = "destination city cannot be null")
    @Size(min = 3,max = 3)
    private String destination;
    @NotBlank(message = "date cannot be null")
    private String date;
    @Id
    @NotBlank(message = "flightnumber cannot be null")
    @Size(min = 5,max = 6)
    private String flightNumber;
    private Integer fare;

    public FlightSearch(int id, String source, String destination, String date, String flightNumber) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.flightNumber = flightNumber;
    }

    public FlightSearch(Integer id, String source, String destination, String date, String flightNumber) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.flightNumber = flightNumber;
    }

    public FlightSearch(int id, String source, String destination, String date, String flightNumber, Integer fare) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.flightNumber = flightNumber;
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "FlightSearch{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", fare='" + fare + '\'' +
                '}';
    }

    public FlightSearch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}