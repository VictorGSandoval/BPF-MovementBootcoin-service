package com.bootcamp.movementbootcoinservice.service;


import com.bootcamp.movementbootcoinservice.model.MovementBootcoin;
import com.bootcamp.movementbootcoinservice.repository.MovementBootcoinRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
@AllArgsConstructor
//@ConditionalOnProperty(name = "cache.enabled", havingValue = "false")
public class MovementBootcoinService implements IMovementBootcoinService {

    //Clorox
    @Autowired
    private MovementBootcoinRepository repository;


    @Override
    public Flux<MovementBootcoin> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<MovementBootcoin> save(MovementBootcoin currency) {
        return  repository.save(currency);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<MovementBootcoin> update(String id, MovementBootcoin product) {
        return repository.findById(id).flatMap(newProduct -> {
            product.setId(newProduct.getId());
            product.setCreateDate(LocalDate.now());
            return repository.save(product);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<MovementBootcoin> findById(String id) {
        return repository.findById(id);
    }

}
