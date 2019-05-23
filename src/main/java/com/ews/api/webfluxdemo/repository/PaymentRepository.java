package com.ews.api.webfluxdemo.repository;

import com.ews.api.webfluxdemo.model.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {


}
