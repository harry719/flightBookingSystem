package com.flightfare.flightfare.service;


import com.flightfare.flightfare.model.Fare;
import com.flightfare.flightfare.model.FlightFare;
import com.flightfare.flightfare.repository.FareRopository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FareServiceImpl implements FareService {


    Logger logger = LoggerFactory.getLogger(Fare.class);

    @Autowired
    FareRopository fareRopository;



   /* List<Fare> list;

    public FareServiceImpl(){
        list=new ArrayList<>();
        list.add(new Fare("BF101", "152"));
        list.add( new Fare("BH104", "104"));
    }
   */

    @Override
    public FlightFare getfare() {

        FlightFare flightFare = new FlightFare();
        flightFare.setFlightFare(this.fareRopository.findAll());
        System.out.println(flightFare);
        logger.info("details of flights");

        return flightFare;
    }

    @Override
    public Fare setfare(Fare fare) {
        logger.info("Setting the fare");
       return fareRopository.save(fare);
         }

    @Override
    public Optional<Fare> getfare(String flightid) {
      return this.fareRopository.findById(flightid);
    }

}
