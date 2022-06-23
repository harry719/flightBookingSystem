package com.example.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @GetMapping("/message")
    public String FlightFallback() {
        return "Service is down at this moment, please try again later.";
    }

}