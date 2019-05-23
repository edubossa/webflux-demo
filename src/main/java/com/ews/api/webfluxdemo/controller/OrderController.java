package com.ews.api.webfluxdemo.controller;

import com.ews.api.webfluxdemo.model.Order;
import com.ews.api.webfluxdemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController extends AbstractCrudController<Order> {

    @Autowired
    public OrderController(OrderRepository repository) {
        super(repository);
    }

}
