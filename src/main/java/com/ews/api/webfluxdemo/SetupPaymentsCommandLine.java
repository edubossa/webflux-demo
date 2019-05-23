package com.ews.api.webfluxdemo;

import com.ews.api.webfluxdemo.model.Payment;
import com.ews.api.webfluxdemo.repository.PaymentRepository;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

//@Component
public class SetupPaymentsCommandLine implements CommandLineRunner {

    @Autowired
    private PaymentRepository repository;

    @Override
    public void run(String... args) {

        if (StringUtils.isEmpty(args[0])) return;

        final List<Payment> payments = new ArrayList<>();
        for(int i = 0; i < Integer.valueOf(args[0]); i++) {
            final Payment payment = Payment.builder()
                                            .id(UUID.randomUUID().toString())
                                            .price(BigDecimal.valueOf(new Random().nextDouble()))
                                        .build();
            payments.add(payment);
        }

        this.repository.deleteAll()
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(Void aVoid) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        payments.forEach(p -> repository.save(p).subscribe(System.out::println));
                    }
                });

    }

}
