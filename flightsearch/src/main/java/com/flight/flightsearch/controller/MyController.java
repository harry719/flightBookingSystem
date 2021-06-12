package com.flight.flightsearch.controller;

import com.flight.flightsearch.model.AuthenticationRequest;
import com.flight.flightsearch.model.AuthenticationResponse;
import com.flight.flightsearch.model.FlightSearch;
import com.flight.flightsearch.repository.AudienceRepo;
import com.flight.flightsearch.repository.FlightSearchRepository;
import com.flight.flightsearch.service.FlightService;
import com.flight.flightsearch.service.MyUserDetailsService;
import com.flight.flightsearch.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/search")
public class MyController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    AudienceRepo audienceRepo;

    @Autowired
    JwtUtil jwtTokenUtil;

    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightSearchRepository flightSearchRepository;

    Logger logger = LoggerFactory.getLogger(FlightSearch.class);

    @GetMapping("/hello")
    public String sayhello() {
        return "hello";
    }

    @GetMapping("/flights")
    public ResponseEntity<List<FlightSearch>> getFlights() {
        logger.info("get all the flights");
        List<FlightSearch> flightSearch = this.flightService.getFligts();
        HttpHeaders headers = new HttpHeaders();
        headers.add("getflight", "to get list of all flights");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(flightSearch);
    }

    @PostMapping("/flights")
    public ResponseEntity<FlightSearch> save(@RequestBody @Valid FlightSearch flightSearch) {
        logger.info("enter details of flight");
        FlightSearch flightSearch1 = this.flightService.save(flightSearch);

        HttpHeaders headers = new HttpHeaders();
        headers.add("setflight", "To add the flight Details");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }

    @GetMapping("/flight/{flightNumber}")
    public Optional<FlightSearch> SearchById(@PathVariable("flightNumber") String flightNumber) {
        logger.info("details of specific flight");
        return this.flightService.searchById(flightNumber);
    }

    @GetMapping("/bookflight")
    public List<FlightSearch> bookflight(@RequestParam("source") @Valid String source, @RequestParam("destination") @Valid String destination, @RequestParam("date") @Valid String date) {
        logger.info("enter the details to book flight");
        List<FlightSearch> flightsearch = this.flightService.bookflight(source, destination, date);
        return flightsearch;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect UserName or Password !", e);
        }

        final org.springframework.security.core.userdetails.UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
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

