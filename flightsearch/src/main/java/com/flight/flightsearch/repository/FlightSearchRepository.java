package com.flight.flightsearch.repository;



import com.flight.flightsearch.model.FlightSearch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSearchRepository extends MongoRepository<FlightSearch,String> {


}
