package com.flightfare.flightfare.model;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection= "fare")
public class Fare {
    @Id
    @NotBlank(message = "flightId is must")
    @Size(min = 5,max = 7)
    private String flightid;

    @NotNull(message = "fare is mandatory")
    private Integer flightfare;


    @Override
    public String toString() {
        return "Fare{" +
                "flightid='" + flightid + '\'' +
                ", flightfare='" + flightfare + '\'' +
                '}';
    }

    public String getFlightid() {
        return flightid;
    }

    public void setFlightid(String flightid) {
        this.flightid = flightid;
    }

    public int getFlightfare() {
        return flightfare;
    }

    public void setFlightfare(int flightfare) {
        this.flightfare = flightfare;
    }

    public Fare() {
    }

    public Fare(String flightid, int flightfare) {
        this.flightid = flightid;
        this.flightfare = flightfare;
    }

}