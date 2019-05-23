package com.ews.api.webfluxdemo.controller;

import com.ews.api.webfluxdemo.model.Product;
import com.ews.api.webfluxdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController extends AbstractCrudController<Product> {

    @Autowired
    public ProductController(ProductRepository repository) {
        super(repository);
    }

}
