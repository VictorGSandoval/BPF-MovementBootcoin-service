package com.bootcamp.movementbootcoinservice.controller;


import com.bootcamp.movementbootcoinservice.model.MovementBootcoin;
import com.bootcamp.movementbootcoinservice.service.IMovementBootcoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movementbootcoin")
public class MovementBootcoinController {
    private final IMovementBootcoinService service;

    @GetMapping
    public Flux<MovementBootcoin> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<MovementBootcoin> getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<MovementBootcoin> create(@RequestBody MovementBootcoin product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Mono<MovementBootcoin> update(@PathVariable String id, @RequestBody MovementBootcoin product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
