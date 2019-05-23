package com.ews.api.webfluxdemo.json;

import lombok.Data;

@Data
public class OrderJson implements Json {

    private String customerId;
    private AddressJson billingAddress;
    private AddressJson shippingAddress;

}
