package com.ews.api.webfluxdemo.repository;

import com.ews.api.webfluxdemo.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
