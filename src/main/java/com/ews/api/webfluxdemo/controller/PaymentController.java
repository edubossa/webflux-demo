package com.ews.api.webfluxdemo.controller;

import com.ews.api.webfluxdemo.model.Payment;
import com.ews.api.webfluxdemo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;


@RestController
@RequestMapping("/payments")
public class PaymentController extends AbstractCrudController<Payment> {

    @Autowired
    private RestTemplate restTemplate;

    private PaymentRepository repository;

    @Autowired
    public PaymentController(PaymentRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Payment>> getStrean() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        return Flux.zip(interval, this.repository.findAll());
    }
    
}
