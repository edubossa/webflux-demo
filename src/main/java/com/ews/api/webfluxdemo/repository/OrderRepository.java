package com.ews.api.webfluxdemo.repository;

import com.ews.api.webfluxdemo.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {


}
