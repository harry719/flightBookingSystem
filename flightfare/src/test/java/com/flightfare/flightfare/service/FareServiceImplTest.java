package com.flightfare.flightfare.service;

import com.flightfare.flightfare.model.Fare;
import com.flightfare.flightfare.model.FlightFare;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FareServiceImplTest {

   FareServiceImpl fareServiceImplMock=mock(FareServiceImpl.class);


    @Test
    public void setFareTest(){
        Fare fareList = new Fare("BF101",101);
        when(fareServiceImplMock.setfare(fareList)).thenReturn(fareList);
        assertEquals(fareList,fareServiceImplMock.setfare(fareList));
        }


    @Test
    public void getfareTest(){
        Fare fareList1 = new Fare("BF101",101);
        Fare fareList2 = new Fare("BF101",101);
        List<Fare> farelist = new ArrayList<Fare>();
        farelist.add(fareList1);
        farelist.add(fareList2);

        FlightFare flightFare = new FlightFare(farelist);
        when(fareServiceImplMock.getfare()).thenReturn(flightFare);
        assertEquals(flightFare, fareServiceImplMock.getfare());

    }


}
