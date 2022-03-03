package com.bootcamp.movementbootcoinservice.service;


import com.bootcamp.movementbootcoinservice.model.MovementBootcoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovementBootcoinService {

     Flux<MovementBootcoin> findAll();

     Mono<MovementBootcoin> save(MovementBootcoin client);

     Mono<Void> delete(String id);

     Mono<MovementBootcoin> update(String id, MovementBootcoin product);

     Mono<MovementBootcoin> findById(String id);

}
