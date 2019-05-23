package com.ews.api.webfluxdemo.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@Document
public class Payment implements Model {

    public enum StatusPayment {
        NotFinished,
        Authorized,
        PaymentConfirmed,
        Denied,
        Voided,
        Refunded,
        Pending
    }

    @Id
    private String id;
    private StatusPayment status;
    private String cardNumber;
    private String brand;
    private int installments;
    private BigDecimal price;

    private String orderId;

    public String getOrderUrl() {
        return "http://localhost:8080/orders/" + this.orderId;
    }

}
