package com.ews.api.webfluxdemo.model;

import lombok.Getter;
import org.springframework.data.annotation.PersistenceConstructor;

import java.math.BigDecimal;

@Getter
public class LineItem implements Model {

    private Product product;

    private BigDecimal price;

    private int amount;

    public LineItem() { }

    public LineItem(Product product) {
        this(product, 1);
    }

    @PersistenceConstructor
    public LineItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
        this.price = product.getPrice();
    }

    public BigDecimal getUnitPrice() {
        return this.price;
    }

    public BigDecimal getTotal() {
        if (this.price == null) {
            this.price = this.product.getPrice();
        }
        return this.price.multiply(BigDecimal.valueOf(this.amount));
    }

}
