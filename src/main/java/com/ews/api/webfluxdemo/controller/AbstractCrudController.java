package com.ews.api.webfluxdemo.controller;

import com.ews.api.webfluxdemo.model.Model;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractCrudController<T extends Model> {

    private static final String MESSAGE_FALLBACK = "API is not working, tray again latter...";

    private ReactiveMongoRepository repository;

    public AbstractCrudController(ReactiveMongoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<?> getAll() {
        return HystrixCommands
                .from(this.repository.findAll())
                .fallback(Flux.just(MESSAGE_FALLBACK))
                .commandName("getAll")
                .toFlux();
    }

    @GetMapping(path = "/{id}")
    public Mono<?> getById(@PathVariable("id") String id){
        return HystrixCommands
                .from(this.repository.findById(id))
                .fallback(Mono.just(MESSAGE_FALLBACK))
                .commandName("getById")
                .toMono();
    }

    @GetMapping(path = "/count")
    public Mono<Long> count() {
        return HystrixCommands
                .from(this.repository.count())
                .fallback(Mono.just(MESSAGE_FALLBACK))
                .commandName("count")
                .toMono();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<?> save(@RequestBody T model){
        return HystrixCommands
                .from(this.repository.save(model))
                .fallback(Mono.just(MESSAGE_FALLBACK))
                .commandName("save")
                .toMono();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") String id) {
        return HystrixCommands
                .from(this.repository.deleteById(id))
                .fallback(Mono.just(MESSAGE_FALLBACK))
                .commandName("save")
                .toMono();
    }

}
