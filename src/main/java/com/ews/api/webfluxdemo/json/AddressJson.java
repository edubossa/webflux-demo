package com.ews.api.webfluxdemo.json;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressJson implements Json {

    private String country;
    private String city;
    private String street;
    private int number;

}
