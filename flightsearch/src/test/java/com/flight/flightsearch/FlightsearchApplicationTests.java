package com.flight.flightsearch;


import com.flight.flightsearch.repository.FlightSearchRepository;
import com.flight.flightsearch.service.FlightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class FlightsearchApplicationTests {

	@Autowired
	private FlightService flightService;
	@MockBean
	private FlightSearchRepository flightSearchRepository;

	@Test
	void contextLoads() {
	}
}
