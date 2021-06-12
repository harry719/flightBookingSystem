package com.flight.flightdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FlightdiscoveryserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightdiscoveryserverApplication.class, args);
	}

}
