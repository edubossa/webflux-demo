package com.ews.api.webfluxdemo.controller;

import com.ews.api.webfluxdemo.model.Customer;
import com.ews.api.webfluxdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractCrudController<Customer> {

    @Autowired
    public CustomerController(CustomerRepository repository) {
        super(repository);
    }
}
