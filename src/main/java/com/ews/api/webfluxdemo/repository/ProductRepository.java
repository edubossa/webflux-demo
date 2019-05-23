package com.ews.api.webfluxdemo.repository;

import com.ews.api.webfluxdemo.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
