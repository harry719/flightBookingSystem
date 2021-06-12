package com.flightfare.flightfare.repository;


import com.flightfare.flightfare.model.Fare;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRopository extends MongoRepository<Fare,String> {


}
