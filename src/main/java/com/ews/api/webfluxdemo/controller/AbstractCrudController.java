package com.ews.api.webfluxdemo.controller;

import com.ews.api.webfluxdemo.model.Model;
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
        return this.repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Mono<?> getById(@PathVariable("id") String id){
        return this.repository.findById(id);
    }

    @GetMapping(path = "/count")
    public Mono<Long> count() {
        return this.repository.count();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<?> save(@RequestBody T model){
        return this.repository.save(model);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") String id) {
        return this.repository.deleteById(id);
    }

}
