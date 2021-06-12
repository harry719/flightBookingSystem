package com.flight.flightsearch.service;

import com.flight.flightsearch.model.FlightSearch;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FlightServiceImplTest {

    FlightServiceImpl flightServiceImplMock = mock(FlightServiceImpl.class);

    @Test
    public void saveFlightTest() {
        FlightSearch flight = new FlightSearch(1, "BF101", "NYC", "SFO", "26-JAN-16", 101);
        when(flightServiceImplMock.save(flight)).thenReturn(flight);
        assertEquals(flight, flightServiceImplMock.save(flight));
    }

    @Test
    public void getFlightTest() {
        FlightSearch flight1 = new FlightSearch(1, "BF101", "NYC", "SFO", "26-JAN-16", 101);
        FlightSearch flight2 = new FlightSearch(2, "BF102", "NYC", "SFO", "27-JAN-16", 102);
        List<FlightSearch> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);
        when(flightServiceImplMock.getFligts()).thenReturn(flightList);
        assertEquals(flightList, flightServiceImplMock.getFligts());
    }


//    @Test
//    public void getsearchbyIdTest() {
//       FlightSearch flight = new FlightSearch(1, "BF101", "NYC", "SFO", "26-JAN-16", 101);
//        when(flightServiceImplMock.searchById("BF101")).thenReturn(Optional.of(flight));
//        assertEquals(flight, flightServiceImplMock.searchById("BF101"));
//    }


    @Test
    public void getFlightsTest() {
        when(flightServiceImplMock.getFligts()).thenReturn(Stream.of(new FlightSearch(1, "JPR", "BLR", "26-JAN-17", "HB104", 125), new FlightSearch(2, "HBR", "TLR", "26-FEB-18", "HB101", 101)).collect(Collectors.toList()));
        assertEquals(2, flightServiceImplMock.getFligts().size());
    }
}
