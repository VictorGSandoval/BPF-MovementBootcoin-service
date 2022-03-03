package com.bootcamp.movementbootcoinservice.repository;

import com.bootcamp.movementbootcoinservice.model.MovementBootcoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementBootcoinRepository extends ReactiveMongoRepository<MovementBootcoin, String> {

   // Mono<MovementBootcoin> findByPhoneNumber(String phoneNumber);

}