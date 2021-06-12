package com.flightfare.flightfare.controller;

import com.flightfare.flightfare.model.Fare;
import com.flightfare.flightfare.model.FlightFare;
import com.flightfare.flightfare.service.FareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController

@RequestMapping("/fare")
public class MyController {

    @Autowired
    private FareService fareService;
    Logger logger = LoggerFactory.getLogger(Fare.class);


    @PostMapping("/")
    public ResponseEntity<Fare> setfare(@RequestBody @Valid Fare fare){
        logger.info("Entered Fare Details");
        Fare fare1=fareService.setfare(fare);

        HttpHeaders headers = new HttpHeaders();
        headers.add("setFare","To add the flight with fare");
        return  ResponseEntity.status(HttpStatus.OK).headers(headers).build();


    }

    @GetMapping("/flightfare")
    public FlightFare fare(){
        logger.info("All the flights with their fare");
        return this.fareService.getfare();

//        HttpHeaders headers = new HttpHeaders();
//        headers.add("flightfare detail","To checck flight fare");
//        return  ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }
    @GetMapping("/{flightid}")
    public Optional<Fare> getfare(@PathVariable("flightid") String flightid){
        return this.fareService.getfare(flightid);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}

