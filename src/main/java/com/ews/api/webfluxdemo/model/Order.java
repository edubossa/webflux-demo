package com.ews.api.webfluxdemo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Document
public class Order implements Model {

    @Id
    private String id;
    private String customerId;
    private Address billingAddress;
    private Address shippingAddress;
    private Set<LineItem> lineItems = new HashSet<>();

    public void addItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }

    public BigDecimal getTotal() {
        return lineItems.stream()
                        .map(item -> item.getTotal())
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
