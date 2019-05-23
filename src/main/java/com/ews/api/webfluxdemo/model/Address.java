package com.ews.api.webfluxdemo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address implements Model {

    private String country;
    private String city;
    private String street;
    private int number;

}
